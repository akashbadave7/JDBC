package com.bridgeit.programs;

import java.sql.*;


public class Dbmd2 {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","root");
		DatabaseMetaData dbmd = con.getMetaData();
		String table[]={"Table"};
		ResultSet rs = dbmd.getTables(null, null, null, table);
		while (rs.next())
		{
			System.out.println(rs.getString(3));
		}
		con.close();
	}

}
