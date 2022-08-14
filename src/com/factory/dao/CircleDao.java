package com.factory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.factory.configuration.JDBCSingleton;
import com.factory.entities.Circle;
import com.factory.entities.Entity;

public class CircleDao implements DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Circle circle;

	@Override
	public void add(Entity e) {
		try {
			String query = " insert into circle (radius, pi) values (?,?);";
			conn = JDBCSingleton.getConnection();
			ps = conn.prepareStatement(query);
			circle = (Circle)e;
			ps.setInt(1, circle.getRadius());
			ps.setDouble(2, circle.getPi());
			ps.executeUpdate();
			System.out.println("Circle back.");
		}catch(SQLException ex) {
			System.err.println("Can't circle back." + ex);
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(conn != null)
					conn.close();		
			}catch(SQLException ex) {
				System.err.println("Can't close " + ex);
			}
		}
		
	}

	@Override
	public List<Map<String, String>> read() {
		List<Map<String,String>>circles = new ArrayList<>();
		try {
			String query = "select * from circle;";
			conn = JDBCSingleton.getConnection();
			ps = conn.prepareStatement(query);
			rs =  ps.executeQuery();
			
			while(rs.next()) {
				Map<String, String>circle = new LinkedHashMap<>();
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					circle.put(rs.getMetaData().getColumnName(i), rs.getString(i));
				}
				circles.add(circle);
				for (Map.Entry<String, String>entry : circle.entrySet()) {
					System.out.println("Key: " + entry.getKey() +" "+"Value: "+entry.getValue());
				}
				
			}
		}catch(SQLException ex) {
			System.err.println("Can't circle back.");
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(conn != null)
					conn.close();
			}catch(SQLException ex) {
				System.out.println("Can't close circle.");
			}
		}
		return circles;
	}

	@Override
	public void update(Entity e) {
		try {
		String query = "update circle set radius = ? where circleId = ? ;";
		conn = JDBCSingleton.getConnection();
		ps = conn.prepareStatement(query);
		circle = (Circle)e;
		ps.setInt(1, circle.getRadius());
		ps.setInt(2, circle.getId());
		ps.executeUpdate();
		System.out.println("Got circle back.");

		}catch(SQLException ex) {
			System.err.println("Can't circle back. " + ex);
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(conn != null)
					conn.close();
			}catch(SQLException ex) {
				System.out.println("Can't close circle.");
			}
		}
	}

	@Override
	public void delete(int id) {
		try {
			String query = "delete from circle where circleId = ?;";
			conn = JDBCSingleton.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Circle deleted.");
		}catch(SQLException ex) {
			System.err.println("Can't delete circle. " + ex);
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(conn != null)
					conn.close();
			}catch(SQLException ex) {
				System.out.println("Can't close circle.");
			}
		}	
	}

	@Override
	public void getArea() {
		try {
			String query = "select * from circle;";
			conn = JDBCSingleton.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String>circle = new HashMap<>();
				
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					circle.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));
				}
				double area = Integer.parseInt(circle.get("radius"))*
						Double.parseDouble(circle.get("pi"));
				System.out.println("Area of circle. " + area);
			}
		}catch(SQLException ex) {
			System.err.println("Can't delete circle. " + ex);
		}finally {
			try {
				if(ps != null)
					ps.close();
				if(conn != null)
					conn.close();
			}catch(SQLException ex) {
				System.out.println("Can't close circle.");
			}
		}
		
	}

}
