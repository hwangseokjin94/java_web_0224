package dao;

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
	//2.selectBymEmail()
	public MemberDTO selectBymEmail(String mEmail) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO result_mDTO = sqlSession.selectOne("mybatis.mapper.member.selectBymEmail", mEmail);
		sqlSession.close();
		return result_mDTO;
	}
	
	
}









