package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.ReplyDTO;
import mybatis.config.DBService;

public class ReplyDAO {

	// Field (DB접근 메소드들이 공통으로 사용)
	private SqlSessionFactory sqlSessionFactory;
	
	// Singleton
	private ReplyDAO() {
		sqlSessionFactory = DBService.getInstance().getSqlSessionFactory();
	}
	private static ReplyDAO rDAO = new ReplyDAO();
	public static ReplyDAO getInstance() {
		return rDAO;
	}
	
	// DB접근 Method

	// 1. selectReplyList()
	public List<ReplyDTO> selectReplyList(int bNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ReplyDTO> list = sqlSession.selectList("mybatis.mapper.reply.selectList", bNo);
		sqlSession.close();
		return list;
	}
	
	// 2. insertReply()
	public int insertReply(ReplyDTO rDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result = sqlSession.insert("mybatis.mapper.reply.insertReply", rDTO);
		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	// 3. deleteReply()
	public int deleteReply(int rNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result = sqlSession.delete("mybatis.mapper.reply.deleteReply", rNo);
		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	
	
}













