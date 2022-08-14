package com.factory.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCSingleton {
	private static JDBCSingleton jdbc;
	private static String url = "jdbc:mysql://localhost:3306/shapesdb?";
	private static String user = "root";
	private static String pass = "root";
	
	
	public JDBCSingleton getInstance() {
		if(jdbc == null) {
			jdbc = new JDBCSingleton();
		}
		return jdbc;

	}	
	static Connection conn = null;

	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
	
	
}
