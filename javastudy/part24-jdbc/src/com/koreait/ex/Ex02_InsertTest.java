package com.koreait.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex02_InsertTest {
	public static void main(String[] args) {
		Connection conn = null; // DB접속
		PreparedStatement ps = null; // 쿼리 전달 및 실행
		String sql = null;// SQL문
		int result = 0; // 실행결과

		// 접속정보
		String user = "HR";
		String password = "1111";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";

		try {

			// 1.접속
			Class.forName(jdbcDriver);
//			Class.forName( "oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);

			// 2.쿼리문 전달 및 실행
			sql = "INSERT INTO JOB VALUES ('과장','내부통제책임',3000,5000)"; // 쿼리문에 세미콜론 붙이지 않는다.
			ps = conn.prepareStatement(sql); // 버스에 sql을 실어 보냈다.
			result = ps.executeUpdate(); // sql 문을 실행하고 실행 결과를 result에 전달한다.
			// 실행 결과
			// 0 : 삽입된 데이터가 0개이다.(실패)
			// 1 : 삽입된 데이터가 1개이다 (성공)
			if (result > 0) {
				System.out.println("JOB이 추가되었다.");
				conn.commit();// 삽입된 데이터를 실제 DB에 저장한다.
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC드라이버가 없다. Build Path확인이 필요하다.");
		} catch (SQLException e) {
			System.out.println("DB접속에 실패했다. 접속정보확인이 필요하다.");
		} finally {

			try {

				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {

			}

		}

	}

}