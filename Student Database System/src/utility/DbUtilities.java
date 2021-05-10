package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtilities {
	public static final String url = "jdbc:mysql://localhost:3306/studentdb";
	public static final String username = "root";
	public static final String password = "root";
	public static Connection connection = null;
	
	public static Connection getDbConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
		connection = DriverManager.getConnection(url,username,password);
		System.out.println("Connection Established");
		return connection;
	}
	
	public static void getDbConnectionClose() throws SQLException{
		if(connection != null){
			connection.close();
		}
	}
}
