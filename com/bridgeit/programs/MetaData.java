package com.bridgeit.programs;
import java.sql.*;
public class MetaData {

	public static void main(String[] args) throws SQLException 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","root");
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("Number of column in table is : "+rsmd.getColumnCount());
			System.out.println("Name of second column is :"+rsmd.getColumnName(2));
			System.out.println("Type of second column is :"+rsmd.getColumnTypeName(2));
			con.close();
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
