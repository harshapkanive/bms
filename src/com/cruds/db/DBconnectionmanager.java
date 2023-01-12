package com.cruds.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cruds.exception.smsException;

public class DBconnectionmanager {
	
	
	
	
	static
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		
	}
    public static Connection getConnection()
    		{
    			Connection conn= null;
    			 try {
    				 
    				 conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","harsha");
    			 }
    			 catch (SQLException e)
    			 {
    				// e.printStackTrace();
    				 throw new smsException("unable to connect to database,contact admin");
    			 }
    			 return conn;
    		}
    
	

}
