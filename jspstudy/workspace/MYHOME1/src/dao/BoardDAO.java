package dao;

import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.config.DBService;

public class BoardDAO {

	// Field (DB접근 메소드들이 공통으로 사용)
	private SqlSessionFactory sqlSessionFactory;
	
	// Singleton
	private BoardDAO() {
		sqlSessionFactory = DBService.getInstance().getSqlSessionFactory();
	}
	private static BoardDAO bDAO = new BoardDAO();
	public static BoardDAO getInstance() {
		return bDAO;
	}
	
 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}