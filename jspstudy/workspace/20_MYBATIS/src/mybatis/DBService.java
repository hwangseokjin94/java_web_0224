package mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/********DBService 의 목적 : SqlSessionFactory를 만들어서 리턴하기 위함이다.**********/

public class DBService {
	//SqlSessionFactory 는 singleton으로 생성한다.
	
	//SqlSessionFactoy 필드 (리턴할대상)
	private SqlSessionFactory sqlSessionFactory;
	
	
	//SqlSessionFactory 필드를 리턴해주는 메소드
	public  SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	//singleton DBService
	private DBService() {
		//SqlSessionFactory 인스턴스를 생성한다.
		try {
			String resource = "mybatis/sqlmap-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static DBService service = new DBService();
	public static DBService getInstance() {
		return service;
	}
}
