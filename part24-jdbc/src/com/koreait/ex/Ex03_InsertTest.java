package com.koreait.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex03_InsertTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;

		String user = "HR";
		String password = "1111";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, user, password);

			String job_id = "부장";
			String job_title = "총무팀장";
			int min_salary = 4000;
			int max_salary = 4000;

			sql = "INSERT INTO JOB VALUES(?,?,?,?)";// ?는 변수를 의미한다.
			ps = conn.prepareStatement(sql);// 쿼리문 전달

			// ?에 값 전달하기
			ps.setString(1, job_id);// setString(저장할 값이 문자열),1번째?에 job_id전달하기
			ps.setString(2, job_title);// 2번째?에 job_title 전달하기
			ps.setInt(3, min_salary);// 3번째?에 min_salary 전달하기
			ps.setInt(4, max_salary);// 4번째?에 max_salary 전달하기

			result = ps.executeUpdate();// 쿼리문실행
			
			
			
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

	}//main
	}
}//class