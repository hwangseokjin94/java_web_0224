package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BlackDTO;
import mybatis.DBService;

public class BlackDAO {

	//BlackDAO는 SqlSessionFactory 인스턴스를 만들어 두고,
	//메소드들이 가져다 사용할 수있도록한다.
	
	//SqlSessionFactory 필드
	
	private  SqlSessionFactory sqlSessionFactory;
	
	
	//singleton
	private BlackDAO(){
		sqlSessionFactory= DBService.getInstance().getSqlSessionFactory(); //DBService getInstance생성하고 인스턴스가지고있는 getSqlSessionFactory메소드를 받아온다...
	}
	private static BlackDAO bDao = new BlackDAO();
	public static BlackDAO getInstance() {
		return bDao;
	}
	
	//실제DB처리하는 메소드 
	//1.insertDTO 
	public int insertDTO(BlackDTO bDto){
		//openSession(false): INSERT UPDATE DELETE 
		// false를하는이유 커밋과관련되어있음 
		
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result= sqlSession.insert("mybatis.black.insert", bDto);
		if(result >0 ) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	//2.selectList()
	public List<BlackDTO> selectList(){
		//openSession(); select 용
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<BlackDTO> list = sqlSession.selectList("mybatis.black.selectList");
		sqlSession.close();
		return list;
	}
	//3.selectOne()
	public BlackDTO selectOne(int no){
		//openSession(); select 용
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BlackDTO bDTO = sqlSession.selectOne("mybatis.black.selectOne",no);
		//BlackDTO bDTO = sqlSession.selectOne("mapper의 id",파라미터);
		sqlSession.close();
		return bDTO;
	}
	
	//4.delete()
	public int delete(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result= sqlSession.delete("mybatis.black.delete", no);
		if(result >0 ) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	//5.update
	public int update(BlackDTO bDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int result= sqlSession.update("mybatis.black.update",bDTO);
		if(result >0 ) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
		
	}
	
	

}

















