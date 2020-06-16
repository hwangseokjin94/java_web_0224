package dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.MemberDTO;
import mybatis.config.DBService;

public class MemberDAO {

	// Field (DB접근 메소드들이 공통으로 사용)
	private SqlSessionFactory sqlSessionFactory;
	
	// Singleton
	private MemberDAO() {
		sqlSessionFactory = DBService.getInstance().getSqlSessionFactory();
	}
	private static MemberDAO mDAO = new MemberDAO();
	public static MemberDAO getInstance() {
		return mDAO;
	}
	
	// DB접근 Method

	// 1. selectBymIdmPw()
	public MemberDTO selectBymIdmPw(MemberDTO mDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO result_mDTO = sqlSession.selectOne("mybatis.mapper.member.selectBymIdmPw", mDTO);
		sqlSession.close();
		return result_mDTO;
	}
	
	// 2. selectBymEmail()
	public MemberDTO selectBymEmail(String mEmail) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO result_mDTO = sqlSession.selectOne("mybatis.mapper.member.selectBymEmail", mEmail);
		sqlSession.close();
		return result_mDTO;
	}
	
	// 3. selectBymIdmPhone()
	public MemberDTO selectBymIdmPhone(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO mDTO = sqlSession.selectOne("mybatis.mapper.member.selectBymIdmPhone", map);
		sqlSession.close();
		return mDTO;
	}
	
	// 4. updatemPw()
	public int updatemPw(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result = sqlSession.update("mybatis.mapper.member.updatemPw", map);
		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	// 5. selectBymId()
	public MemberDTO selectBymId(String mId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO mDTO = sqlSession.selectOne("mybatis.mapper.member.selectBymId", mId);
		sqlSession.close();
		return mDTO;
	}
	
	
	//6.insertmDTO()
	public int insertmDTO(MemberDTO mDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result = sqlSession.insert("mybatis.mapper.member.insertmDTO", mDTO);
		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	//7.deletemDTO()
	public int deletemDTO(String mId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result = sqlSession.delete("mybatis.mapper.member.deletemDTO", mId);
		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	
}









