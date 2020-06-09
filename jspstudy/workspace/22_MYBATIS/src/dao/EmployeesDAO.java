package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.EmployeesDTO;
import mybatis.config.DBService;

public class EmployeesDAO {

	// Field
	private SqlSessionFactory sqlSessionFactory;
	
	// Singleton
	private EmployeesDAO() {
		sqlSessionFactory = DBService.getInstance().getSqlSessionFactory();
	}
	private static EmployeesDAO eDAO = new EmployeesDAO();
	public static EmployeesDAO getInstance() {
		return eDAO;
	}
	
	// DB처리 Method
	//1.selectList()
	public List<EmployeesDTO> selectList(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EmployeesDTO> list = sqlSession.selectList("mybatis.mapper.employees.selectList");
		sqlSession.close();
		return list;
	}
	//2.selectByDept()
	public List<EmployeesDTO> selectByDept( Map<String, String[]> map){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EmployeesDTO> list = sqlSession.selectList("mybatis.mapper.employees.selectDept",map);
		sqlSession.close();
		return list;
		
	}
	//2.selectByDynamic()
	public List<EmployeesDTO> selectByDynamic( Map<String, String> map){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EmployeesDTO> list = sqlSession.selectList("mybatis.mapper.employees.selectDynamic",map);
		sqlSession.close();
		return list;
		
	}
	
	
}
