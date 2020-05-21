package ex1_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*5.URlMapping 값을  애너테이션 @WebServlet() 수정하는 방법
 * 		@WebServlet("/URlMapping")
 * .*/
@WebServlet("/Ex03")
public class Ex03_urlmapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Ex03_urlmapping() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Third servlet");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
