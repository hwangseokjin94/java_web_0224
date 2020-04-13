package com.koreait.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex04_SelectTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 검색 결과를 저장할수있는 rs 셀렉트만 대리고다닌다.
		String sql = null;

		String user = "HR";
		String password = "1111";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";

		try {

			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(url, user, password);

			sql = "SELECT * FROM JOB";
			ps = conn.prepareStatement(sql);

			// SELECT 실행은 executeQuery()
			rs = ps.executeQuery();// sql 실행결과를 rs에 저장한다.

			// rs에 저장된 테이블을 열(칼럼)별로 분리해서 읽을때는 getter를 사용한다.
			// rs=job_id+job_title+ min_salary+max_salary
			// 1) job_id: rs.getString(1), rs.getString("job_id")
			// 2) job_title: rs.getString(2), rs.getString("title")
			// 3) min_salary: rs.getInt(3), rs.getInt("min_salary")
			// 4) max_salary: rs.getInt(4), rs.getInt("max_salary")

			// 반복문을 새용해서 rs에저장된 행(Row)들을 읽는다.

			while (rs.next()) {

				String job_id = rs.getString(1);
				String job_title = rs.getString(2);
				int min_salary = rs.getInt("min_salary");
				int max_salary = rs.getInt("max_salary");

				System.out.println(job_id + ", " + job_title + ", " + min_salary + ", "+ max_salary);

			}

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC드라이버가 없다. Build Path확인이 필요하다.");
		} catch (SQLException e) {
			System.out.println("쿼리싱행실을 실패하였다.");
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {

			}

		}

	}// main

}// class
