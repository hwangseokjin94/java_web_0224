package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	// Field
	private static String user = "javaweb0224";
	private static String password = "1111";
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	
	// Method
	public static Connection getConnection() throws Exception {
		Class.forName(jdbcDriver);
		return DriverManager.getConnection(url, user, password);
	}

}