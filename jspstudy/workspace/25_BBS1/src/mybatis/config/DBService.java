package mybatis.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {

	// Field
	private SqlSessionFactory sqlSessionFactory;

	// Method
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	// Singleton
	private DBService() {
		try {
			String resource = "mybatis/config/sqlmap-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static DBService service = new DBService();
	public static DBService getInstance() {
		return service;
	}
	
}
