package dao;
//DB 업무를 처리하는 클래스
//DAO :  Database Access Object

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.BlueDto;



public class BlueDao {

	//필드 필드들의 디폴트는  null
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	//생성자 (singleton pattern)
	//1. BlueDao  클래스 이외의 곳에서는 new BlueDao()를 호출할수 없도록한다. 
	//2. new BlueDao()를 해서 인스턴스(객체)를 하나 생성해둔다.
	//3. 인스턴스를 가져다 사용할수 있는 메소드(getInstance)를 하나 생성해둔다.
	
	//static :메모리에 1개의 객체를 올려두고 공유해서 사용할수있다.
	//객체가 없는데 무슨 수로 호출할것인가??? 스택틱메소드는 스택틱 변수를 이용해야된다.
	private BlueDao() {	}            //나만만들수있당
	private static BlueDao bDao = new BlueDao();
	public static BlueDao getInstance() { // BlueDao인스턴스(객체)가 없어도 getInstance()를 호출할수있도록 클래스 메소드(static)로만든다
		return bDao;
	}
	
	//메소드
	/********1.db접속*********/
	public Connection getConnection() {
		try {
			
			String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user ="JAVAWEB0224";
			String password="1111";
			Class.forName(jdbcDriver);
			conn =DriverManager.getConnection(url, user, password);
		}catch (Exception e) {}			
			return conn;				
	}
	
	//*****************2.clos******/
	public void close(Connection conn , PreparedStatement ps , ResultSet rs) {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {ps.close();}
			if(conn != null) {conn.close();}
		}catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	
	/******* 3.insert *리턴결과는정수****/
	public int insert(BlueDto bDto) {
		int result= 0;	
		try {
			conn = getConnection();
			conn.setAutoCommit(false); //자동커밋 OFF
			sql = "INSERT INTO BLUE VALUES (BLUE_SEQ.NEXTVAL,?,?,?,?,?,SYSDATE)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, bDto.getId());		
			ps.setString(2, bDto.getPw());		
			ps.setString(3, bDto.getName());		
			ps.setInt(4, bDto.getAge());		
			ps.setString(5, bDto.getEmail());		
			result = ps.executeUpdate();
			
			if(result > 0 ) { // insert 가 성공하면, 
				conn.commit();//수동커밋
				
			}
		} catch (Exception e) {		
			try {
				
				if(conn != null) {conn.rollback();}
			} catch (Exception e2) {	}	
		}finally {
			try {				
				if(conn != null) {conn.setAutoCommit(true);}
			} catch (Exception e2) {}
			close(conn,ps,null);
		}//
		return result;
		
	}//insert
	
	/*************4. idCheck()*********/
	public boolean idCheck(String id) {
		boolean result =false;
		
		try {
			conn = getConnection();
			sql = "SELECT ID FROM BLUE WHERE ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if( !rs.next()) {//검색된 결과 집합이 없으면 (해당아이디를 가진 회원이 없다.)
				result = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return result;
	}//
	
	/***************5.list()************ResultSet결과집합***/
	public ArrayList<BlueDto> list() {
		ArrayList<BlueDto> list = new ArrayList<BlueDto>();
		try {
			conn =getConnection();
			sql ="SELECT NO, ID, PW, NAME, AGE, EMAIL, REG_DATE FROM BLUE";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BlueDto bDto = new BlueDto();
				bDto.setNo(rs.getInt("NO"));
				bDto.setId(rs.getString("ID"));
				bDto.setPw(rs.getString("PW"));
				bDto.setName(rs.getString("NAME"));
				bDto.setAge(rs.getInt("AGE"));
				bDto.setEmail(rs.getString("EMAIL"));
				bDto.setReg_date(rs.getDate("REG_DATE"));
				list.add(bDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return list;
	}
	/*********6 view*******/
	public BlueDto view(String id) {
		BlueDto bDto = null;
		try {
			conn =getConnection();
			sql = "SELECT NO, ID, PW, NAME, AGE, EMAIL, REG_DATE FROM BLUE WHERE ID =?";
			ps= conn.prepareStatement(sql);
			ps.setString(1, id);
			rs= ps.executeQuery();
			if( rs.next() ) {
				bDto = new BlueDto(); //검색결과가 있어야 만들기.
				bDto.setNo(rs.getInt("NO"));
				bDto.setId(rs.getString("ID"));
				bDto.setPw(rs.getString("PW"));
				bDto.setName(rs.getString("NAME"));
				bDto.setAge(rs.getInt("AGE"));
				bDto.setEmail(rs.getString("EMAIL"));
				bDto.setReg_date(rs.getDate("REG_DATE"));
			}
			
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return bDto;
	}//view
	
	/**********7.delete()*******/
	
	public int delete(String id) {
		int result = 0;
		try {
			conn = getConnection();
			sql = "DELETE FROM BLUE WHERE ID = ?";
			ps= conn.prepareStatement(sql);
			ps.setString(1, id);
			result=ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, null);
		}
		return result;
	}
		
	/**********8.update()*******/
	
	public int update(BlueDto bDto) {
		int result = 0;
		try {
			conn = getConnection();
			sql = "UPDATE BLUE SET NAME =?,AGE =?,EMAIL =? WHERE ID = ?";					
			ps= conn.prepareStatement(sql);			
			ps.setString(1, bDto.getName());
			ps.setInt(2, bDto.getAge());
			ps.setString(3, bDto.getEmail());
			ps.setString(4, bDto.getId());
			result=ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, null);
		}
		return result;
	}
		
	
	
	
	/**********9.updatePw()*******/
	
	public int updatePw(BlueDto bDto) {
		int result = 0;
		try {
			conn = getConnection();
			sql = "UPDATE BLUE SET PW =? WHERE ID = ?";					
			ps= conn.prepareStatement(sql);			
			ps.setString(1, bDto.getPw());
			ps.setString(2, bDto.getId());
			result=ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, null);
		}
		return result;
	}
	
	
	
	
}










