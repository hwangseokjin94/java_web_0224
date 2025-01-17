package ex1_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿을 실행하는 방법
 * 	
 * 	  1. 이클립스에서 실행한다.
 * 	  2. 서버를 켜 놓고 , URL을 직접 입력한다.
 * 	  		1)호스트이름 : 포트번호 / 컨택스트 패스 /URLMapping
 * 			2)호스트이름 : 포트번호 / 프로젝트이름 /서블릿이름
 * 	  3.URLMapping 값을 변경할수있다.	
 * 			1)web.xml에서 변경한다.
 * 			2)애너테이션 @WebServlet() 으로 변경한다.
 * 	  4. web.xml 에서 URLMapping 수정하는 방법
  			<servlet>
  				<servlet-name>MyServlet</servlet-name>
  				<servlet-class>servlet.Ex02_urlmapping</servlet-class>
  			</servlet>
  			<servlet-mapping>
  				<servlet-name>MyServlet</servlet-name>
  				<url-pattern>/Ex02</url-pattern>
  			</servlet-mapping>			
 * 
 * 
 */
@WebServlet("/Ex02_urlmapping")
public class Ex02_urlmapping extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public Ex02_urlmapping() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Second servlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
