package com.bridgeit.programs;

import java.sql.*;
import java.util.Scanner;



public class JdbcOperation {

	public static void main(String[] args) throws SQLException {
		try {
			Scanner scanner = new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/akash","root","root");
			Statement statement = connection.createStatement();
			while(true)
			{
				System.out.println("Enter you choice");
				System.out.println("1. Insert Record");
				System.out.println("2. Delete Record");
				System.out.println("3. Update Record");
				System.out.println("4. Display Record");
				System.out.println("5. Exit");
				int choice = scanner.nextInt();
				int i;
				switch(choice)
				{
						
				case 1: CallableStatement stmt = connection.prepareCall("{call insertEmp(?,?,?,?,?)}");
						
						System.out.println("Enter id");
						int id = scanner.nextInt();
						System.out.println("Enter first name");
						String fname = scanner.next();
						System.out.println("Enter last name");
						String lname = scanner.next();
						System.out.println("Enter age");
						int age = scanner.nextInt();
						System.out.println("Enter salary");
						int salary = scanner.nextInt();
						
						/*String sql = "select id from employee";
						ResultSet result = stmt.executeQuery(sql);
						
						while(result.next())
						{	
							if(result.getInt(1)==id)
							{
								System.out.println("Id alredy exits.");
								break;
							}
							else
							{*/
								stmt.setInt(1, id);
								stmt.setString(2, fname);
								stmt.setString(3, lname);
								stmt.setInt(4, age);
								stmt.setInt(5, salary);
								i = stmt.executeUpdate();
								System.out.println(i+ " record added succesfully");
							//}
						//}
						
					break;
					
				case 2: PreparedStatement deleteStatement = connection.prepareStatement("delete from employee where id =?");
						System.out.println("Enter user id to delete record");
						id = scanner.nextInt();
						deleteStatement.setInt(1, id);
						i = deleteStatement.executeUpdate();
						System.out.println(i+ " record deleted");
					break;
				case 3 : System.out.println("Enter the user id to update");
							id = scanner.nextInt();
							System.out.println("What your want to update");
							System.out.println("Fname,Lname,age,salary");
							String update = scanner.next();
							PreparedStatement updateStatement = connection.prepareStatement("update employee set "+update+" = ? where id = ?");
							System.out.println("Enter the update value to be insert");
							String value = scanner.next();
							updateStatement.setString(1, value);
							updateStatement.setInt(2, id);
							i = updateStatement.executeUpdate();
							System.out.println(i+ " record updated");
					break;
					
				case 4 : 	PreparedStatement selectStatement = connection.prepareStatement("select * from employee");
							ResultSet rs = selectStatement.executeQuery();
						while(rs.next())
						{
							System.out.println("ID: "+rs.getInt(1)+" Fname: "+rs.getString(2)+" Lname: "+rs.getString(3)+" Age: "+rs.getInt(4)+" Salary: "+rs.getInt(5));
						}
					break;
				default : return;
				
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
