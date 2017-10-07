package com.bridgeit.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoringFile {

	public static void main(String[] args) throws SQLException, FileNotFoundException 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","root");
			PreparedStatement ps = con.prepareStatement("insert into FILETABLE values(?,?)");
			File file=new File("/home/bridgeit/Akash/file.txt");  
			FileReader fr=new FileReader(file);  
			
			ps.setInt(1,101);  
			ps.setCharacterStream(2,fr,(int)file.length());  
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");  
			              
			con.close();  
			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
