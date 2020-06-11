package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.GuestbookDTO;
import mybatis.config.DBService;

public class GuestbookDAO {
	
	 //Field DB접근 메소드들이 공통으로 사용
	 private SqlSessionFactory sqlSessionFactory ;
	 //singletond
	 private GuestbookDAO() {
		 sqlSessionFactory = DBService.getInstance().getSqlSessionFactory();
	 }
	 private static GuestbookDAO gDAO = new GuestbookDAO();
	 public static GuestbookDAO getInstance() {
		 return gDAO;
	 }
	 
	 //DB접근 METHOD
	 
	 //1.selectList()
	 public List<GuestbookDTO> selectList(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<GuestbookDTO> list =  sqlSession.selectList("mybatis.mapper.guestbook.selectList");
		sqlSession.close();
		return list;
	 }
	 //2.insertDTO()
	 public int insertDTO(GuestbookDTO gDTO){
		 SqlSession sqlSession = sqlSessionFactory.openSession(false);
		 int result  =  sqlSession.insert("mybatis.mapper.guestbook.insert",gDTO);
		 if(result>0) {
			 sqlSession.commit();
		 }
		 
		 sqlSession.close();
		 return result;
	 }
	 
	 //3. selectByNo()
	 public GuestbookDTO selectByNo(int no) {
		 SqlSession sqlSession = sqlSessionFactory.openSession();
		 GuestbookDTO gDTO = sqlSession.selectOne("mybatis.mapper.guestbook.selectByNo", no);
		 sqlSession.close();
		 return gDTO;
		 
		 
		 
	 }
	 
	 //.4 updateDTO()
	 public int updateDTO(GuestbookDTO gDTO) {
		 SqlSession sqlSession = sqlSessionFactory.openSession(false);		 
		 int result = sqlSession.update("mybatis.mapper.guestbook.update", gDTO);
		 if(result > 0 ) {
			 sqlSession.commit();
		 }
		 return result;
		 
	 }
		//5.deleteDTO()
		public int deleteDTO(int no) {
			SqlSession sqlSession = sqlSessionFactory.openSession(false);
			int result= sqlSession.delete("mybatis.mapper.guestbook.delete", no);
			if(result >0 ) {
				sqlSession.commit();
			}
			sqlSession.close();
			return result;
		}	 
		
		//6.selectByQuery()
		public List<GuestbookDTO> selectByQuery(String query){
			SqlSession sqlSession = sqlSessionFactory.openSession();
			List<GuestbookDTO> list= sqlSession.selectList("mybatis.mapper.guestbook.selectByQuery", query);
			sqlSession.close();
			return list;
		}
	 
	 
 
	
}



















