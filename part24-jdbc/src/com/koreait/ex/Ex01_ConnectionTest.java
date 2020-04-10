package com.koreait.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01_ConnectionTest {

	public static void main(String[] args) {

		//Oracle DB와 연결할떄는 Connection 객체를 사용한다
		Connection conn = null;
		//선행조건
		//Oracle사 (DB벤더) 에서 Oracle DB와 JAVA를 연결할수있는 클래스를 제공한다.
		//-->JDBC 드라이버(각 DB벤더에서 제공) DB업체에서 제공 오라클은 다운로드 필요없다
		// Oracle 11g XE : ojdbc6.jar 사용할수있도록 셋팅
		//프로젝트 -  Build path - Configure build path -Libraries - Add External JARs
		//C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
		
		//접속 정보
		String user = "HR";
		String password = "1111";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		
		//DB 접속은 예외처리가 반드시필요하다.
		
		try {
			Class.forName(jdbcDriver); //OracleDriver를 메모리에 올림
			conn = DriverManager.getConnection(url, user, password);//접속정보를 이용해서 DB접속
			
			System.out.println("DB접속에 성공했다.");
		}catch(ClassNotFoundException e) {
			
			System.out.println("JDBC드라이버가 없다. Build Path확인이 필요하다.");
		}catch (SQLException e) {
			System.out.println("DB접속에 실패했다. 접속정보확인이 필요하다.");
		}finally {
			
			try {
				if(conn != null) {conn.close();}
			} catch (Exception e) {
			
			}
			
		}
		
		
		
		
		
	}

}
