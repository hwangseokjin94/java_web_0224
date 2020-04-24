package com.koreait.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.connect.DBConnect;

// DAO : Database Access Object
// 데이터베이스에 접근(Access)하는 오브젝트
// DAO 를 통해서 CRUD 를 처리한다.
// CREATE(삽입), READ(검색), UPDATE(갱신), DELETE(삭제)

public class Dao {

	// Field (디폴트로 null 과 0 으로 초기화가 된다.)
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private int result;
	private String sql;

	// Constructor
	public Dao() {
		try {
			conn = DBConnect.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method

	// 1. 삽입 메소드
	public int insert(String job_id, String job_title, int min_salary, int max_salary) {

		try {

			sql = "INSERT INTO JOB VALUES (?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, job_id);
			ps.setString(2, job_title);
			ps.setInt(3, min_salary);
			ps.setInt(4, max_salary);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	// 2. 삭제 메소드
	public int delete(String job_id) {

		try {

			sql = "DELETE FROM JOB WHERE JOB_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, job_id);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	// 3. 업데이트 메소드
	public int update(String job_id, int min_salary, int max_salary) {

		try {

			sql = "UPDATE JOB SET MIN_SALARY = ? , MAX_SALARY = ? WHERE JOB_ID =?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, min_salary);
			ps.setInt(2, max_salary);
			ps.setString(3, job_id);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	// 4. 검색 메소드
	public ResultSet select(String job_id) {

		try {

			sql = "SELECT * FROM JOB WHERE JOB_ID =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, job_id);
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;

	}

}
