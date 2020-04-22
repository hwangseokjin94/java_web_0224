package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connect.DBConnect;

public class Ex03_CreateSequence {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		try {
			
			conn = DBConnect.getConnection();
			
			
			sql=	"CREATE SEQUENCE m_seq "+
					"INCREMENT BY 1 "+
					"START WITH 1 "+
					"MAXVALUE 999999 "+
					"NOCYCLE "+
					"NOCACHE";
					
			
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
