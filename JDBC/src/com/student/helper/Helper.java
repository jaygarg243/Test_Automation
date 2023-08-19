package com.student.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Helper {

	private static Connection connection;
	private static PreparedStatement preparedstatement;
	
	public static PreparedStatement getPreparedStatement(String sql) {
		try {
			
			//Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Make a connection
			Helper.connection = DriverManager.getConnection("jdbc:mysql://localhost/students","root","Mandarin@123");
			//Create Query
			Helper.preparedstatement = Helper.connection.prepareStatement(sql);
			
			return Helper.preparedstatement;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnection() {
		try {
			Helper.connection.close();
			Helper.preparedstatement.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
