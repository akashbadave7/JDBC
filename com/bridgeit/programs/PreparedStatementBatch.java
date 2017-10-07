package com.bridgeit.programs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
public class PreparedStatementBatch 
{
	public static void main(String[] args) throws SQLException, IOException
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","root");
			PreparedStatement stmt=con.prepareStatement("insert into emp values(?,?,?)");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			
			while(true){
				System.out.println("Enter the user id");
				int id = Integer.parseInt(br.readLine());
				System.out.println("Enter user name");
				String name = br.readLine();
				System.out.println("Enter age");
				int age = Integer.parseInt(br.readLine());
				
				stmt.setInt(1, id);
				stmt.setString(2, name);
				stmt.setInt(3, age);
				stmt.addBatch();
				
				System.out.println("Do you want to continue: y/n");
				String s = br.readLine();
				if(s.startsWith("n"))
				{
					break;
				}
			}
			stmt.executeBatch(); 
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
