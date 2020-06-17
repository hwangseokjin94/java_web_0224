package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BoardDTO;
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
	
	// DB접근 Method
	
	// 1. boardList()
	public List<BoardDTO> boardList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BoardDTO> list = sqlSession.selectList("mybatis.mapper.board.boardList", map);
		sqlSession.close();
		return list;
	}
	
	// 2. getTotalRecord()
	public int getTotalRecord() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.selectOne("mybatis.mapper.board.getTotalRecord");
		sqlSession.close();
		return result;
	}
	
	//3.insertbDTO()
	public int insertbDTO(BoardDTO bDTO) {
		SqlSession sqlSession =sqlSessionFactory.openSession(false);
		int result = sqlSession.insert("mybatis.mapper.board.insertbDTO",bDTO);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	//4 selectBybNo
	public BoardDTO selectBybNo(int bNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO bDTO = sqlSession.selectOne("mybatis.mapper.board.selectBybNo", bNo);
		sqlSession.close();
		return bDTO;
	}
	//5.updatebHit()
	public int updatebHit(int bNo){
		SqlSession sqlSession =sqlSessionFactory.openSession(false);
		int result = sqlSession.update("mybatis.mapper.board.updatebHit",bNo);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	//6 updatebStep()
	//
	public int updatebStep(BoardDTO bDTO){
		SqlSession sqlSession =sqlSessionFactory.openSession(false);
		int result = sqlSession.update("mybatis.mapper.board.updatebStep",bDTO);
		if(result>0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	
	
	
	
	
	
	
	
}