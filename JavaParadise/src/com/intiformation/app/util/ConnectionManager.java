package com.intiformation.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

	private final static String url = "jdbc:mysql://localhost:3306/java_paradise?serverTimezone=UTC";
	private final static String user= "root";
	private final static String pwd= "";
	private static Connection S_CONNECTION ;

		
		
		private ConnectionManager(){
			// Avoid external invoction
		}
		public static Connection getConnection() {
			if (S_CONNECTION == null) {
				loadJDBCDriver() ;
				try {
				S_CONNECTION = DriverManager.getConnection(url,user,pwd);
				S_CONNECTION.setAutoCommit(false); // Transaction! Cf cours TODO le rollback
				}catch (SQLException e){
					e.printStackTrace();
					System.err.print("Cannot create connection") ;
				}
			}		
			return S_CONNECTION ;
		}
		// Loading driver
		public static void loadJDBCDriver() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Driver MySQL not Found !");
			}
			System.out.println("Connection established");
			
		}

		public static void close(){
		
			if (S_CONNECTION != null) {
				
				try {
					S_CONNECTION.close();
				}catch (SQLException e){
					e.printStackTrace();
					System.err.print("Error! You're always connected!") ;
				}
			}
		}
	}
