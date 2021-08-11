package dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dal.Settings;
public class JdbcTools {
	private static String urldb;
	private static String userdb;
	private static String passworddb;
	
	static {
		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		passworddb = Settings.getProperty("passworddb");
		
		System.out.println("urldb=" + urldb);
		System.out.println("userdb=" + userdb);
		System.out.println("passworddb=" + passworddb);
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");   
		Connection connexion = DriverManager.getConnection(urldb, userdb, passworddb);
		return connexion;
	}

}
