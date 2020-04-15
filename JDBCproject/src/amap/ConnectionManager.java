package amap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Ceci est un Singleton [designe pattern qui permet d'instancier la classe pour UN objet

public final class ConnectionManager {

private final static String url = "jdbc:mysql://localhost:3306/jdbcbegining?serverTimezone=UTC";
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
				System.err.print("Cannot create couillection") ;
			}
		}		
		System.out.println("You are linked to MySQL data base");
		return S_CONNECTION ;
	}
	// Loading driver
	public static void loadJDBCDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver MySQL not Found du cul!");
		}
		System.out.println("Couillection established");
	}
	
}
