package com.koreait.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex06_UpdateTest {
public static void main(String[] args) {
	Connection conn = null;
	PreparedStatement ps= null;
	String sql = null;
	int result = 0 ; 
	String user = "HR";
	String password = "1111";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String jdbcDriver="oracle.jdbc.driver.OracleDriver";
	
	
	try {
		Class.forName(jdbcDriver);
		
		conn = DriverManager.getConnection(url, user, password);

		sql = "UPDATE JOB SET MIN_SALARY =7000,MAX_SALARY=9000 WHERE JOB_ID='부장' ";
		ps = conn.prepareStatement(sql);
		result = ps.executeUpdate();
		
		System.out.println(result);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(ps!=null) {ps.close();}
			if(conn!=null) {conn.close();}
		} catch (Exception e) {	}
	}
	
}
}
