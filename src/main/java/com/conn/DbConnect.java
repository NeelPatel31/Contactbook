package com.conn;
import java.sql.*;

public class DbConnect {
	
	public static Connection getConn() {
		
		String JdbcURL = "jdbc:mysql://localhost:3306/ajava";
	      String Username = "root";
	      String password = "admin";
	      Connection con = null;
	      try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         System.out.println("Connecting to database..............."+JdbcURL);
	         con=DriverManager.getConnection(JdbcURL, Username, password);
	         System.out.println("Connection is successful!!!!!!");
	      }
	      catch(Exception e) {
	    	 System.out.println("No..............");
	    	 System.out.println(e.getMessage());
	         e.printStackTrace();
	      }
//		Connection conn=null;
//		String url="jdbc:mysql://localhost:3306/ajava?useSSL=false";
//		String driver="com.mysql.jdbc.Driver";
//		
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, "root", "admin");
//		    System.out.println("Connection Established");
//		    System.out.println("Ok..");
//		}
//		
//		catch(Exception e) {
//			System.out.println("Not good.");
//			System.out.println(e.getMessage());
//		}
		return con;
	}
}
