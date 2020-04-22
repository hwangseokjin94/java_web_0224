package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connect.DBConnect;
import dto.MemberDto;

public class MemberDao {

	// Field
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	private int result;

	// Constructor
	public MemberDao() {
		try {
			conn = DBConnect.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Method
	// 1. 회원가입 메소드
	public int insert(MemberDto mDto) {
		try {

			sql = "INSERT INTO members VALUES (m_seq.NEXTVAL,?,?,?,?,SYSDATE)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mDto.getmId());
			ps.setString(2, mDto.getmPw());
			ps.setString(3, mDto.getmName());
			ps.setString(4, mDto.getmEmail());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	// 2.회원검색 메소드(mId)
	public ResultSet selectBymId(String mId) {

		try {
			sql = "SELECT * FROM members WHERE mID =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mId);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	// 3.이메일 검색 메소드(mEmail)
	public ResultSet selectBymEmail(String mEmail) {
		try {
			sql = "SELECT *FROM members WHERE mEmail =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mEmail);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;

	}

	// 4.회원 탈퇴 메소드
	public int delete(String mId) {

		try {
			sql = "DELETE FROM members WHERE mId = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mId);
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 5. 회원정보 수정 메소드
	public int update(MemberDto mDto) {

		try {
			sql = "UPDATE members SET mPw =?,mEmail = ? WHERE mId = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, mDto.getmPw());
			ps.setString(2, mDto.getmEmail());
			ps.setString(3, mDto.getmId());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
	
	
	//6.회원검색  (mId 또는mEmail)
	public ResultSet selectBymIdmEmail(String query) {
		try {
			sql = "SELECT * FROM members WHERE mId = ? OR mEmail = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, query);
			ps.setString(2, query);
			rs = ps.executeQuery();
		}catch (Exception e) {
		e.printStackTrace();
		}
		return rs;
		
	}

}
