package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.EmployeeDTO;
import mybatis.config.DBService;

public class EmployeesDAO {
	private SqlSessionFactory sqlSessionFactory;
	private EmployeesDAO() {
		sqlSessionFactory =DBService.getInstance().getSqlSessionFactory();
		
	}
	private static EmployeesDAO eDAO = new  EmployeesDAO();
	public static EmployeesDAO getInstance() {
		return eDAO;
		
	}
	public List<EmployeeDTO> selectByTitle(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<EmployeeDTO> list =sqlSession.selectList("mybatis.mapper.employees.search_title");
		
		sqlSession.close();		
		return list;
	}
}
