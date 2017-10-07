package com.bridgeit.programs;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class RetrivingImage {

	public static void main(String[] args) throws SQLException, IOException 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","root");
			PreparedStatement ps = con.prepareStatement("select * from IMGTABLE");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				Blob b = rs.getBlob(2);
				byte bytes[] = b.getBytes(1, (int) b.length());
				
				FileOutputStream fout = new FileOutputStream("/home/bridgeit/Akash/India.jpg");
				fout.write(bytes);
				fout.close();
			}
			System.out.println("Ok");
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
