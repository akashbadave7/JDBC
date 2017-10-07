package com.bridgeit.programs;

import java.sql.*;

public class StatementBatch {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","root");
			Statement statement = connection.createStatement();
			
			statement.addBatch("insert into login values ('mahesh')");
			statement.addBatch("insert into login values ('hjhjj')");
			
			statement.executeBatch();
			System.out.println("success");
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
