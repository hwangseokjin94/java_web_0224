package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.memberDTO;
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
	//selectBymIdmPw()
	public memberDTO selectBymIdmPw(memberDTO mDTO) {
		SqlSession sqlSession  =sqlSessionFactory.openSession();
		memberDTO result_mDTO = sqlSession.selectOne("mybatis.mapper.member.selectBymIdmPw",mDTO);
		sqlSession.close();
		return result_mDTO;
	}


}






