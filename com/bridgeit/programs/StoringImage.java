package com.bridgeit.programs;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
public class StoringImage {

	public static void main(String[] args) throws SQLException, IOException 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","root");
			PreparedStatement ps = con.prepareStatement("insert into IMGTABLE values(?,?)");
			ps.setString(1, "india");
			FileInputStream fis = new FileInputStream("/home/bridgeit/Downloads/india.jpg");
			ps.setBinaryStream(2,fis,fis.available());  
			int i = ps.executeUpdate();
			System.out.println(i + " record inserted");
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
