package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ex05_insert {

	public static void main(String[] args) {

		Connection conn =null;
		PreparedStatement ps = null;
		String[] sqls = {
				"INSERT INTO GREEN (IDX,ID,PW,NAME,AGE,ADDR,REG_DATE) VALUES(GREEN_SEQ.NEXTVAL,'id1','1111','제임스',20,'서울',SYSDATE)",
				"INSERT INTO GREEN (IDX,ID,PW,NAME,AGE,ADDR,REG_DATE) VALUES(GREEN_SEQ.NEXTVAL,'id2','1111','앨리스',50,'독도',SYSDATE)",
				"INSERT INTO GREEN (IDX,ID,PW,NAME,AGE,ADDR,REG_DATE) VALUES(GREEN_SEQ.NEXTVAL,'id3','1111','랠뤼시',45,'제주',SYSDATE)",
				"INSERT INTO GREEN (IDX,ID,PW,NAME,AGE,ADDR,REG_DATE) VALUES(GREEN_SEQ.NEXTVAL,'id4','1111','사만다',31,'부천',SYSDATE)",
				"INSERT INTO GREEN (IDX,ID,PW,NAME,AGE,ADDR,REG_DATE) VALUES(GREEN_SEQ.NEXTVAL,'id5','1111','홍길동',29,'시흥',SYSDATE)"
				
				
		};
		int result = 0;
		int count = 0;
		
		try {
			conn =DBConnect.getConnection();
			for(String sql : sqls) {
				
				ps =conn.prepareStatement(sql);
				result = ps.executeUpdate();
				if(result >0) {
					System.out.println("등록성공 현재"+(++count)+"명");
				}		
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
