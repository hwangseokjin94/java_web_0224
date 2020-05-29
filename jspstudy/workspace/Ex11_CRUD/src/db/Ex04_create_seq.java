package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ex04_create_seq {

	public static void main(String[] args) {

		Connection conn =null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		
		try {
			conn =DBConnect.getConnection();
			sql = "CREATE SEQUENCE GREEN_SEQ";
			ps =conn.prepareStatement(sql);
			result = ps.executeUpdate();
			if(result != -1) {
				System.out.println("GREEN_SEQ 생성");
			}		
							
		} catch (Exception e) {
			
		}finally {
			try {
				if(ps!=null) {ps.close();}
				if(conn!=null) {conn.close();}
			}catch (Exception e) {
				
				
			}
		}
	}

}
