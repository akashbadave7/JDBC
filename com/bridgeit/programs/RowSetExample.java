package com.bridgeit.programs;

import java.sql.SQLException;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.RowSetWriter;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetExample {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
		    //Creating and Executing RowSet  
			rowSet.setUrl("jdbc:mysql://localhost:3306/akash");
			rowSet.setUsername("root");
			rowSet.setPassword("root");
			
			rowSet.setCommand("select * from emp");
			rowSet.execute();
		//	rowSet.addRowSetListener(new MyListener());  
			
			while (rowSet.next())
			{
				System.out.println("ID :"+rowSet.getInt(1));
				System.out.println("Name :"+rowSet.getString(2));
				System.out.println("Age :"+rowSet.getInt(3));
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
}

class MyListener implements RowSetListener {  
    public void cursorMoved(RowSetEvent event) {  
              System.out.println("Cursor Moved...");  
    }  
   public void rowChanged(RowSetEvent event) {  
              System.out.println("Cursor Changed...");  
   }  
   public void rowSetChanged(RowSetEvent event) {  
              System.out.println("RowSet changed...");  
   }  
} 
