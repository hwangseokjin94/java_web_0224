package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BBSDTO;
import mybatis.config.DBService;

public class BBSDAO {

	// Field (DB접근 메소드들이 공통으로 사용)
	private SqlSessionFactory sqlSessionFactory;
	
	// Singleton
	private BBSDAO() {
		sqlSessionFactory = DBService.getInstance().getSqlSessionFactory();
	}
	private static BBSDAO bDAO = new BBSDAO();
	public static BBSDAO getInstance() {
		return bDAO;
	}
	
	// DB접근 Method

	// 1. selectBBSList()
	public List<BBSDTO> selectBBSList(Map<String, Integer> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BBSDTO> list = sqlSession.selectList("mybatis.mapper.bbs.selectBBSList", map);
		sqlSession.close();
		return list;
	}
	
	// 2. selectTotalRecord()
	public int selectTotalRecord() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalRecord = sqlSession.selectOne("mybatis.mapper.bbs.totalRecord");
		sqlSession.close();
		return totalRecord;
	}
	
	// 3. insertBBS()
	public int insertBBS(BBSDTO bDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result = sqlSession.insert("mybatis.mapper.bbs.insertBBS", bDTO);
		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	// 4. selectBBSBybNo()
	public BBSDTO selectBBSBybNo(int bNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BBSDTO bDTO = sqlSession.selectOne("mybatis.mapper.bbs.selectBBSBybNo", bNo);
		sqlSession.close();
		return bDTO;
	}
	
	// 5. updatebHit()
	public int updatebHit(BBSDTO bDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result = sqlSession.update("mybatis.mapper.bbs.updatebHit", bDTO);
		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	// 6. updateBBS()
	public int updateBBS(BBSDTO bDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result = sqlSession.update("mybatis.mapper.bbs.updateBBS", bDTO);
		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	// 7. updateBBSWithFile()
	public int updateBBSWithFile(BBSDTO bDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result = sqlSession.update("mybatis.mapper.bbs.updateBBSWithFile", bDTO);
		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	// 8. deleteBBS()
	public int deleteBBS(int bNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result = sqlSession.delete("mybatis.mapper.bbs.deleteBBS", bNo);
		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}