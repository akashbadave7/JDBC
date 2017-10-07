package com.bridgeit.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","root");
		Statement stmt=con.createStatement();  
		con.setAutoCommit(false);
		//stmt.executeUpdate("insert into login values('jon')");
		//con.commit();
		stmt.executeUpdate("insert into login values('raju')");
		con.rollback();
		System.out.println("succes");
		con.close();
	}
}
