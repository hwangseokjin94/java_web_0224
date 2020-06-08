package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BlackDTO;
import mybatis.config.DBService;

public class BlackDAO {
	private SqlSessionFactory sqlSessioFactory;
	private BlackDAO() {
		sqlSessioFactory =DBService.getInstance().getSqlSessionFactory();		
	}
	private static BlackDAO bDAO = new BlackDAO();
	public static  BlackDAO getInstance() {
		return bDAO ;
	}
		
	//1.selectByTitle()
	public List<BlackDTO> selectByTitle(String q){
		SqlSession sqlSession = sqlSessioFactory.openSession();
		List<BlackDTO> list =sqlSession.selectList("mybatis.mapper.black.search_title",q);
		
		sqlSession.close();		
		return list;
	}
	
	//2.selectByContent()
	public List<BlackDTO> selectByContent(String q){
		SqlSession sqlSession = sqlSessioFactory.openSession();
		List<BlackDTO> list =sqlSession.selectList("mybatis.mapper.black.search_content",q);
		
		sqlSession.close();
		return list;
	}
	//3.selectByBoth()
	public List<BlackDTO> selectByBoth(String q){
		SqlSession sqlSession = sqlSessioFactory.openSession();
		List<BlackDTO> list =sqlSession.selectList("mybatis.mapper.black.search_both",q);
		
		sqlSession.close();
		return list;
	}
	
	
}
