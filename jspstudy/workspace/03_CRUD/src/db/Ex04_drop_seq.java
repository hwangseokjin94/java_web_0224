package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex04_drop_seq {

	public static void main(String[] args) {
		
		Connection conn = null ;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		
		
		
		
		try {
			conn =DBConnect.getConndection();
			sql ="DROP SEQUENCE RED_SEQ ";				 ;
				
			ps =conn.prepareStatement(sql);
			result = ps.executeUpdate();
			if(result != -1) {
				System.out.println("RED 시퀀스 삭제");
				}
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
		e.printStackTrace();
		}
		finally {
			try {
				if( ps!= null){ps.close();};
				if(conn != null) {conn.close();}
			}catch (Exception e) {

			}
		}
	}

}
