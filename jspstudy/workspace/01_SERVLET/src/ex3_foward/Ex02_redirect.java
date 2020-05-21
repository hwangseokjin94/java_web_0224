package ex3_foward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/Ex02_redirect")
public class Ex02_redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Ex02_redirect() {
        super();
        
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");

		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>forward</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("Ex02_from.html에서 전달된 정보를 Ex02_to.java 서블릿으로 보낸다.<br/>");
		out.println("redirect 로 이동하면 기존의 request는 사라지기 때문에 실제로 전달되지않는다.<br/>");
		out.println("이름: " + name + ", 나이: " + age + "<br/>");
		
		//redirect
		response.sendRedirect("/01_SERVLET/Ex02_to");
		
		//redirect를 하게되면 실제로 해당 페이지는 보이지 않는다.
		
		out.println("</body>");
		out.println("</html>");

		//새로고침을 허용하지않겠다하면 redirect
		//새로고침을해도되면 forward    
		
		
		
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
