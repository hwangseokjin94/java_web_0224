package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BBSDTO;
import mybatis.config.DBService;

public class BBSDAO {
	
	 //Field DB접근 메소드들이 공통으로 사용
	 private SqlSessionFactory sqlSessionFactory ;
	 //singletond
	 private BBSDAO() {
		 sqlSessionFactory = DBService.getInstance().getSqlSessionFactory();
	 }
	 private static BBSDAO bDAO = new BBSDAO();
	 public static BBSDAO getInstance() {
		 return bDAO;
	 }
	 
	 //DB접근 METHOD
	 
	 //1.selectBBSList()
	 public List<BBSDTO> selectBBSList(Map<String, Integer> map){
		 SqlSession sqlSession = sqlSessionFactory.openSession();
		 List<BBSDTO> list = sqlSession.selectList("mybatis.mapper.bbs.selectBBSList",map);
		 sqlSession.close();
		 return list;
	 }
	 //2.selectTotalRecord()
	 public int selectTotalRecord() {
		 SqlSession sqlSession = sqlSessionFactory.openSession();
		 int totalRecord =  sqlSession.selectOne("mybatis.mapper.bbs.totalRecord");
		 sqlSession.close();
		 return totalRecord;
	 }
	 	 
	 
 
	
}



















