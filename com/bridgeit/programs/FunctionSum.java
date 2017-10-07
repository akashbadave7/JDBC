package com.bridgeit.programs;
import java.sql.*;
public class FunctionSum {

	public static void main(String[] args)  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/akash","root","root");
			
			CallableStatement stmt = con.prepareCall("{?=call sumOfNumber(?,?)}");
			stmt.setInt(2, 10);
			stmt.setInt(3, 20); 
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.execute();
			System.out.println(stmt.getInt(1));
			
		} catch (ClassNotFoundException  | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
