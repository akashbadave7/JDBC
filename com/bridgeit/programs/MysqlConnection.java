package com.bridgeit.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","root");
		Statement stmt=con.createStatement();  
		//String query = "delete from emp where id=4";
		//stmt.executeUpdate(query);
		
		ResultSet rs = stmt.executeQuery("select * from emp");
		while (rs.next())
		{
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
		}
		System.out.println("--------------------------");
		rs.absolute(1);
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
		con.close();
	}
}
