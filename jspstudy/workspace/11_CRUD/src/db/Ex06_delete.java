package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ex06_delete {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		try {
			conn = DBConnect.getConnection();
			sql = "DELETE FROM GREEN";
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
			if ( result > 0 ) {
				System.out.println("전체 삭제 성공.");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}