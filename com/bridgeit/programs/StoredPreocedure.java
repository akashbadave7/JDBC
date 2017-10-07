package com.bridgeit.programs;
import java.sql.*;
public class StoredPreocedure {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/akash","root","root");
			
			CallableStatement stmt = con.prepareCall("{call INSERTR(?,?,?)}");
			stmt.setInt(1,7);
			stmt.setString(2, "Raju");
			stmt.setInt(3, 20);
			stmt.execute();
			
			System.out.println("success");
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
