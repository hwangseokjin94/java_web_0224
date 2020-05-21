package ex3_foward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/Ex01_to")
public class Ex01_to extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Ex01_to() {
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
		

		out.println("이름: " + name + ", 나이: " + age + "<br/>");
		
		out.println("<a href='/01_SERVLET/Ex01_to?name="+name+"&age="+age+"'>다시이동</a>");
		
		out.println("</body>");
		out.println("</html>");

		
		
		
		
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
