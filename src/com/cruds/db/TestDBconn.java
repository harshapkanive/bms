

	
	package com.cruds.db;

	import java.sql.Connection;

	public class TestDBconn {
		
		public static void main(String[] args){
			
			
			Connection conn=DBconnectionmanager.getConnection();
			
			if(conn!=null){
				
				System.out.println("connection successful");
			}
		}

	}



