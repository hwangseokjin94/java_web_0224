package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ReplyDTO;
import mybatis.config.DBService;

public class ReplyDAO {
	
	 //Field DB접근 메소드들이 공통으로 사용
	 private SqlSessionFactory sqlSessionFactory ;
	 //singletond
	 private ReplyDAO() {
		 sqlSessionFactory = DBService.getInstance().getSqlSessionFactory();
	 }
	 private static ReplyDAO rDAO = new ReplyDAO();
	 public static ReplyDAO getInstance() {
		 return rDAO;
	 }
	 
	 //DB접근 METHOD
	 
	 //1.selectReplyList()
	 public List<ReplyDTO> selectReplyList(int bNo){
		 SqlSession sqlSession = sqlSessionFactory.openSession();
		 List<ReplyDTO> list= sqlSession.selectList("mybatis.mapper.reply.selectList", bNo);
		 sqlSession.close();
			return list;
	 }
	 
	 
	 	 
	 
 
	
}



















