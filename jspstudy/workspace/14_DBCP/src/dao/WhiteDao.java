package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.WhiteDto;

public class WhiteDao {

	//Field
	private Connection conn ;
	private PreparedStatement ps; 
	private ResultSet rs;
	private String sql;
	
	//Singleton Pattern
	//외부에 공개를하지않는 생성자
	private WhiteDao() {}
	//내가하나만들 어서 주겠어 공유객체를 만들겟ㅆ음 
	private static WhiteDao wDao = new WhiteDao();
	//메소드의 이름은 관례상 getInstance 정해짐
	public static WhiteDao getInstance() {
		return wDao;
	}
	
	//DBCP설정
	private static DataSource ds;
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			//Tomcat은 java:comp/env 를 prefix로 사용한다.
			//ds 객체에 전달되는 Resource의 name은 jdbc/oracle 이다. (content.xml파일의name속성 값을 의미한다.)
			
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	//메소드
	//********************1.close()**************************//
	private void close(Connection conn ,PreparedStatement ps ,ResultSet rs) {
		try {
			if( rs != null ) { rs.close(); }
			if( ps != null ) { ps.close(); }
			if( conn != null ) { conn.close(); } //커넥션의 종료가 아니라 반납을 의미한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/********2.selectByIdPw()*/
	public WhiteDto selectByIdPw(Map<String, String> map) {
		WhiteDto wDto =null;
		try {
			conn = ds.getConnection(); //ds가 관리하는 커넥션을 빌려온다.
			sql = "SELECT * FROM WHITE WHERE ID = ? AND PW = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,map.get("id"));
			ps.setString(2, map.get("pw"));
			rs= ps.executeQuery();
			
			if(rs.next()){
				wDto = new WhiteDto();
				wDto.setNo(rs.getInt("NO"));
				wDto.setId(rs.getString("ID"));
				wDto.setPw(rs.getString("PW"));
				wDto.setName(rs.getString("NAME"));
				wDto.setAge( rs.getInt("AGE") );
				wDto.setEmail(rs.getString("EMAIL"));
				wDto.setReg_date(rs.getDate("REG_DATE"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return wDto;
	}
	
	
	/****************3.selectByEmail()***************/
	
	public WhiteDto selectByEmail(String email) {
		WhiteDto wDto = null;
		try {
			conn = ds.getConnection();
			sql = "SELECT ID, REG_DATE FROM WHITE WHERE EMAIL = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if( rs.next() ) {
				wDto = new WhiteDto();
				wDto.setId(rs.getString("ID"));
				wDto.setReg_date(rs.getDate("REG_DATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return wDto;
	}
	

	/*********      4.isMember()        *******/
	public boolean isMember(String id) {
		boolean result =false;
		try {
			conn =ds.getConnection();
			sql = "SELECT ID FROM WHITE WHERE ID =?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, id);
			rs= ps.executeQuery();
			if(rs.next()) {
				result =true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return result;
	}
	
	
	/*********      5.updatePw()       *******/
	
	public int updatePw(Map<String, String> map) {
		int result = 0;
		try {
			conn =ds.getConnection();
			sql = "UPDATE WHITE SET PW = ? WHERE ID =?";
			ps= conn.prepareStatement(sql);
			ps.setString(1, map.get("pw"));
			ps.setString(2, map.get("id"));
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn, ps, rs);
		}
		return result;
	}
	
	
	
	
	
	
}
