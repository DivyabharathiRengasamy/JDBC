package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static String url="jdbc:mysql://localhost:3306/Student";
	static String uname="root";
	static String password="Divya@22";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,uname,password);
	}
	

}
