package com.recmmendation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	public static Connection con;
	public static String driver="com.mysql.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/travel_recommendation";
	
	public static Connection getConnectin() throws ClassNotFoundException{
	try {
		 Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection(url,"root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		
		return con;
	}
	

	public static void main(String[] args) throws ClassNotFoundException {
		ConnectionManager c = new ConnectionManager();
		
		if(getConnectin()!=null) {
			
			System.err.println("Connection created.....");
			
		}
		
	}
}
