package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connect.DBConnect;

public class Ex01_CreateTable {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		try {
			
			conn = DBConnect.getConnection();
			
			
			sql=	"CREATE TABLE members(" +
					"mNo NUMBER NOT NULL PRIMARY KEY," +
					"mId VARCHAR2(30) NOT NULL UNIQUE," +
					"mPw VARCHAR2(30) NOT NULL," +
					"mName VARCHAR2(30)," +
					"mEmail VARCHAR2(100) UNIQUE," +
					"mRegdate DATE)";
					
			
			ps = conn.prepareStatement(sql);// CREATE ,DROP:성공은0 실패는 -1
			
			result = ps.executeUpdate();
			
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) { ps.close(); }
				if (conn != null) { conn.close(); }
			} catch (Exception e) { }
		}

	}

}
