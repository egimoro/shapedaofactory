package com.factory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.Map;

import com.factory.configuration.JDBCSingleton;
import com.factory.entities.Entity;
import com.factory.entities.Square;

public class SquareDao implements DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Square s;
	@Override
	public void add(Entity e) {
		try {
			String query = "insert into square (squareId, base) values (squareId,?);";
				conn = JDBCSingleton.getConnection();

				ps = conn.prepareStatement(query);
				s = (Square)e;
				ps.setInt(1, s.getBase());
				System.out.println("Added data!");

				ps.executeUpdate();
			
		}catch(SQLException ex) {
			System.err.println("Error. " + ex);
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}if(conn != null) {
					conn.close();
				}
			}catch(SQLException e1) {
				System.err.println(e1 + " Can't close.");
			}
		}	
	}

	@Override
	public List<Map<String, String>> read() {
		List<Map<String,String>>squares = new ArrayList<>();
		try {
			conn = JDBCSingleton.getConnection();
			String query = "select * from square;";
			
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Map<String, String>square = new LinkedHashMap<>();
					for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
						square.put(rs.getMetaData().getColumnName(i), rs.getString(i));
					}
					squares.add(square);
					for(Map.Entry<String, String>entry : square.entrySet()) {
						System.out.println("Key: " + entry.getKey()+
								"\n"+"Value: " + entry.getValue());
					}
					
				}
			
		}catch(SQLException e) {
			System.err.println("Error not able to read. "+ e);
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}if(conn != null) {
					conn.close();
				}
			}catch(SQLException e1) {
				System.err.println(e1 + " Can't close.");
			}
		}
		return squares;
	}

	@Override
	public void update(Entity e) {
		try {
			String query = "update square set base = ? where squareId = ?;";
			conn = JDBCSingleton.getConnection();
			ps = conn.prepareStatement(query);
			
				s = (Square)e;
				ps.setInt(1, s.getBase());
				ps.setInt(2, s.getId());
				ps.executeUpdate();
				System.out.println("Table updated successfully.");
			
		}catch(SQLException ex) {
			System.err.println("Can't update: " + ex);
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}if(conn != null) {
					conn.close();
				}
			}catch(SQLException e1) {
				System.err.println(e1 + " Can't close.");
			}
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			String query = "delete from square where squareId = ?;";
			conn = JDBCSingleton.getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("Data deleted.");
		}catch(SQLException e) {
			System.err.println("Error not able to read. "+ e);
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}if(conn != null) {
					conn.close();
				}
			}catch(SQLException e1) {
				System.err.println(e1 + " Can't close.");
			}
		}
		
	}

	@Override
	public void getArea() {
		try {
			conn = JDBCSingleton.getConnection();
			String query = "select base from square;";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String, String>square = new LinkedHashMap<>();
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					square.put(rs.getMetaData().getColumnName(i), rs.getString(i));
				}
				int area = Integer.parseInt(square.get("base"))*
						Integer.parseInt(square.get("base"));
				System.out.println("Area of square: "+area);
			}
			
		}catch(SQLException e) {
			System.err.println("Error not able to read. "+ e);
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}if(conn != null) {
					conn.close();
				}
			}catch(SQLException e1) {
				System.err.println(e1 + " Can't close.");
			}finally {
				try {
					if(ps != null) {
						ps.close();
					}if(conn != null) {
						conn.close();
					}
				}catch(SQLException e1) {
					System.err.println(e1 + " Can't close.");
				}
			}
		}
		
		
		
	}

}
