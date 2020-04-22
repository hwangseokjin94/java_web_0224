package com.koreait.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	// field
	private static String user = "HR";
	private static String password = "1111";
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String jdbcDriver = "oracle.jdbc.driver.OracleDriver";

	// method
	public static Connection getConnection() throws Exception {
		Class.forName(jdbcDriver);
		return DriverManager.getConnection(url, user, password);
	}
}
