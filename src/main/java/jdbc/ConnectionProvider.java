package jdbc;

import java.sql.*;

public class ConnectionProvider {
	
	private static String url = "jdbc:sqlite:aplicacion.db";
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException{
		if(connection == null) {
			connection = DriverManager.getConnection(url);
		}
		return connection;
	}
	
	

}
