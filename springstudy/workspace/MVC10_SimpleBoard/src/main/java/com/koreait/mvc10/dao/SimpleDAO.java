package com.koreait.mvc10.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.koreait.mvc10.dto.SimplieDTO;

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
	
	//1.SimplelistCommand가 호출할  simpleList()메소드
	public ArrayList<SimplieDTO> simpleList(){
		ArrayList<SimplieDTO> list = new ArrayList<SimplieDTO>();
		try {
			conn = ds.getConnection();
			sql ="SELECT BNO , BWRITER ,BTITLE ,BCONTENT, BDATE FROM SIMPLE";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); //SELECT문은 executeQuery()
			while(rs.next()) {
				int bNo = rs.getInt("BNO");      //rs.getInt(1)
				String bWriter = rs.getString("BWRITER"); //rs.getString(2)
				String bTitle = rs.getString("BTITLE"); //rs.getString(3)
				String bContent = rs.getString("BCONTENT");//rs.getString(4)
				Date bDate = rs.getDate("BDATE");//rs.getString(5)
				SimplieDTO sDTO = new SimplieDTO(bNo, bWriter, bTitle, bContent, bDate);
				list.add(sDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,ps,rs);
		}
		return list;
	}
	
	
	//2.SimpleInsertCommand가 호출할  simpleInsert()메소드
	//매개변수 String bWriter,String bTitle ,String bContent는 
	//.SimpleInsertCommand 크래스에서 받아온다.
	public void simpleInsert(String bWriter,String bTitle ,String bContent) {
		
		try {
			conn = ds.getConnection();
			sql ="INSERT INTO SIMPLE (BNO , BWRITER ,BTITLE ,BCONTENT, BDATE) VALUES (SIMPLE_SEQ.NEXTVAL,?,?,?,SYSDATE)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,bWriter);
			ps.setString(2, bTitle);
			ps.setString(3, bContent);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,ps,null);
		}
		
	}

	//3.SimpleViewCommand가 호출할  simpleView()메소드
	public SimplieDTO simpleView(int bNo) {
		SimplieDTO sDTO = null;
		try {
			conn = ds.getConnection();
			sql ="SELECT BNO , BWRITER ,BTITLE ,BCONTENT, BDATE FROM SIMPLE WHERE BNO = ?";
			ps =conn.prepareStatement(sql);
			ps.setInt(1, bNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				
				String bWriter = rs.getString("BWRITER");  // rs.getString(2)
				String bTitle = rs.getString("BTITLE");  // rs.getString(3)
				String bContent = rs.getString("BCONTENT");  // rs.getString(4)
				Date bDate = rs.getDate("BDATE");  // rs.getDate(5)
				sDTO = new SimplieDTO(bNo, bWriter, bTitle, bContent, bDate);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,ps,rs);
		}
		return sDTO;
	 
	}
	//4.SimpleUpdateCommand가 호출할  simpleUpdate()메소드
	public void simpleUpdate(int bNo,String bTitle ,String bContent){
		try {
			conn = ds.getConnection();
			sql ="UPDATE SIMPLE SET BTITLE =?, BCONTENT =? WHERE BNO = ?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,bTitle);
			ps.setString(2, bContent);
			ps.setInt(3, bNo);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,ps,null);
		}
		
	}
	//8.SimpleDeleteCommand가 호출할  simpleDelete()메소드
	public void simpleDelete(int bNo){
		try {
			conn = ds.getConnection();
			sql ="DELETE FROM SIMPLE WHERE BNO = ?";
			ps = conn.prepareStatement(sql);			
			ps.setInt(1, bNo);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn,ps,null);
		}
		
	}
	
	
}

















