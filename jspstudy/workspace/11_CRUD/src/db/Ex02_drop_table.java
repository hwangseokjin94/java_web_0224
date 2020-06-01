package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ex02_drop_table {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		try {
			conn = DBConnect.getConnection();
			sql = "DROP TABLE GREEN";
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
			if ( result != -1 ) {
				System.out.println("GREEN 테이블 삭제");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if ( ps != null ) { ps.close(); }
				if ( conn != null ) { conn.close(); }
			} catch (Exception e) {	}
		}  // try

	}  // main

}
