package com.koreait.mvc11.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.koreait.mvc11.dto.SimplieDTO;



public class SimpleDAO {

	//커넥션 풀(커넥션을 미리 여러개 만들어 두고 대여,반납하는 방식)
	// 커넥션 풀처리는 DataSource클래스가 담당한다
	private DataSource ds;
	
	//생성
	private SimpleDAO() {
		//context.xml에 작성된 DB접속정보를 읽어들인다.
		try {
			Context context = new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/oracle"); //Tomcat을 사용하는 경우 java:comp/env/ 를 name앞에 추가한다
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private static SimpleDAO sDAO = new SimpleDAO();
	public static SimpleDAO getInstance() {
		return sDAO;
	}
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	//close() 처리느 무저건 메소드마다한다. 그게좋다.
	public void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(conn != null) {conn.close();}
		} catch (Exception e) {
			
		}
	}
	
	//실제 DB 처리하는 메소드
	
	//1.selectSimpleList()
	public ArrayList<SimplieDTO> selectSimpleList(){
		ArrayList<SimplieDTO> list = new ArrayList<SimplieDTO>();
		
		try {
			conn = ds.getConnection();
			sql = "SELECT BNO, BWRITER, BTITLE,BCONTENT,BDATE FROM SIMPLE ORDER BY BNO DESC";
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				int bNo = rs.getInt(1);
				String bWriter =rs.getString(2);
				String bTitle =rs.getString(3);
				String bContent =rs.getString(4);
				Date bDate = rs.getDate(5);
				SimplieDTO sDTO = new SimplieDTO(bNo, bWriter, bTitle, bContent, bDate);
				list.add(sDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		
		
		return list;
	}
	
	
}

















