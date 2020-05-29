package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ex01_create_table {

	public static void main(String[] args) {

		Connection conn =null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		
		try {
			conn =DBConnect.getConnection();
			sql = "CREATE TABLE GREEN("+
						"IDX NUMBER PRIMARY KEY,"+
						"ID VARCHAR2(20) NOT NULL UNIQUE,"+
						"PW VARCHAR2(20) NOT NULL ,"+
						"NAME VARCHAR2(20) NOT NULL,"+
						"AGE NUMBER ,"+
						"ADDR VARCHAR2(20),"+
						"REG_DATE DATE"+
					")";
			ps =conn.prepareStatement(sql);
			result = ps.executeUpdate();
			if(result != -1) {
				System.out.println("GREEN 테이블 생성");
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
