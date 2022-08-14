package com.factory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.factory.configuration.JDBCSingleton;
import com.factory.entities.Entity;
import com.factory.entities.Rectangle;

public class RectangleDao implements DAO{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Rectangle r;

	@Override
	public void add(Entity e) {
		try {
			String query = "insert into rectangle (base,height) values (?,?);";		
			conn = JDBCSingleton.getConnection();
			ps = conn.prepareStatement(query);
			r = (Rectangle)e;
			ps.setInt(1, r.getBase());
			ps.setInt(2, r.getHeight());
			ps.executeUpdate();
			System.out.println("Rectangle drawn.");
		}catch(SQLException ex) {
			System.err.println("Error can't be drawn: " + ex);
		}finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();		
			}catch(SQLException e1) {
				System.out.println("Can't close: " + e1);
			}

		}
	}

	@Override
	public List<Map<String, String>> read() {
		List<Map<String,String>>rectangles = new ArrayList<>();
		try {
			String query = "select * from rectangle;";
			conn = JDBCSingleton.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String>rectangle = new LinkedHashMap<>();
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					rectangle.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));		
				}
				rectangles.add(rectangle);
				for(Map.Entry<String, String>entry : rectangle.entrySet()) {
					System.out.println("Key: " + entry.getKey() +
							"\n"+"Value: " + entry.getValue());
				}
			}
		}catch(SQLException ex) {
			System.err.println("Error can't be drawn: " + ex);
		}finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();		
			}catch(SQLException e1) {
				System.out.println("Can't close: " + e1);
			}

		}
		
		return rectangles;
	}

	@Override
	public void update(Entity e) {
		try {
			String query = "update rectangle set base = ? height = ? where rectangleId = ?;";
			conn = JDBCSingleton.getConnection();
			r = (Rectangle)e;
			ps = conn.prepareStatement(query);
			ps.setInt(1, r.getBase());
			ps.setInt(2, r.getHeight());
			ps.setInt(3, r.getId());
			ps.executeUpdate();
			System.out.println("Rectangle updated successfully.");
		}catch(SQLException ex) {
			System.err.println("Error can't be drawn: " + ex);
		}finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();		
			}catch(SQLException e1) {
				System.out.println("Can't close: " + e1);
			}

		}
		
	}

	@Override
	public void delete(int id) {
		try {
			String query = "delete from rectangle where rectangle;";
			conn = JDBCSingleton.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Shape deleted successfully.");
		}catch(SQLException ex) {
			System.err.println("Error can't be drawn: " + ex);
		}finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();		
			}catch(SQLException e1) {
				System.out.println("Can't close: " + e1);
			}

		}
		
	}

	@Override
	public void getArea() {
		try {
			String query = "select base,height from rectangle;";
			conn = JDBCSingleton.getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String>rectangle = new LinkedHashMap<String, String>();
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					rectangle.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));
				}
				int area = Integer.parseInt(rectangle.get("base")) *
						Integer.parseInt(rectangle.get("height"));
				System.out.println("area of rectangle: " + area);
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();		
			}catch(SQLException e1) {
				System.out.println("Can't close: " + e1);
			}
		}
	}
}
