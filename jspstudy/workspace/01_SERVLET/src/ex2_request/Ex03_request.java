package ex2_request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex03_request")
public class Ex03_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Ex03_request() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>request 정보</title>");
		out.println("</head>");
		out.println("<body>");

		
		//--요청정보를 request 에서 꺼내기
		
		
		request.setCharacterEncoding("utf-8");
				
		
		String name =request.getParameter("name");	
		String age  =request.getParameter("age");	
		String address = request.getParameter("address");

		//--요청정보를 request 에서 꺼내기
		
		out.println("<h3>이름 :"+name +"</h3>");		
		out.println("<h3>나이 :"+age +"</h3>");		
		out.println("<h3>주소 :"+address +"</h3>");
				
		
		
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
