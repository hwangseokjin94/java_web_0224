package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex01_create_table {

	public static void main(String[] args) {
		
		Connection conn = null ;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		
		
		
		
		try {
			conn =DBConnect.getConndection();
			sql ="CREATE TABLE RED ("+
				"NO NUMBER PRIMARY KEY,"+
				"ID VARCHAR2(20) NOT NULL UNIQUE,"+
				"PW VARCHAR2(20) NOT NULL ,"+
				"NAME VARCHAR2(20) NOT NULL , "+
				"AGE NUMBER,"+
				"ADDRESS VARCHAR2(50),"+
				"REGDATE DATE"+
					")";
			ps =conn.prepareStatement(sql);
			result = ps.executeUpdate();
			if(result != -1) {//create,drop은 성공시 -1이아닌값 반화, 실패시 -1
				System.out.println("RED 테이블 생성");
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
