package ex3_foward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/Ex03_forward")
public class Ex03_forward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Ex03_forward() {
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
		
		out.println("Ex03_from.html에서 전달된 정보를 Ex03_to.java 서블릿으로 보낸다.<br/>");
		out.println("forward로 이동하면 기존의 request 다시 전달된다.<br/>");
		out.println("이름: " + name + ", 나이: " + age + "<br/>");
		
		//forward
		//forward의 경로에는 "컨택스트 패스"를 작성하지 않는다.
		request.getRequestDispatcher("/Ex03_to").forward(request, response);
		
		//forward를 하게되면 실제로 해당 페이지는 보이지 않는다.
		
		out.println("</body>");
		out.println("</html>");

		//새로고침을 허용하지않겠다하면 redirect
		//새로고침을해도되면 forward    
		
		
		
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
