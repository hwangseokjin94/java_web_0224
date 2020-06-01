package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ex05_insert {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		String[] sqls = {
			"INSERT INTO GREEN (IDX, ID, PW, NAME, AGE, ADDR, REG_DATE) VALUES (GREEN_SEQ.NEXTVAL, 'id1', '1111', '제임스', 20, '서울', SYSDATE)",
			"INSERT INTO GREEN (IDX, ID, PW, NAME, AGE, ADDR, REG_DATE) VALUES (GREEN_SEQ.NEXTVAL, 'id2', '1111', '에밀리', 21, '경기', SYSDATE)",
			"INSERT INTO GREEN (IDX, ID, PW, NAME, AGE, ADDR, REG_DATE) VALUES (GREEN_SEQ.NEXTVAL, 'id3', '1111', '앨리스', 22, '인천', SYSDATE)",
			"INSERT INTO GREEN (IDX, ID, PW, NAME, AGE, ADDR, REG_DATE) VALUES (GREEN_SEQ.NEXTVAL, 'id4', '1111', '사만다', 23, '대구', SYSDATE)",
			"INSERT INTO GREEN (IDX, ID, PW, NAME, AGE, ADDR, REG_DATE) VALUES (GREEN_SEQ.NEXTVAL, 'id5', '1111', '데이빗', 24, '제주', SYSDATE)"
		};
		int result = 0;
		int count = 0;
		
		try {
			conn = DBConnect.getConnection();
			for ( String sql : sqls ) {
				ps = conn.prepareStatement(sql);
				result = ps.executeUpdate();
				if ( result > 0 ) {
					System.out.println("등록 성공. 현재 " + (++count) + "명");
				}
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
