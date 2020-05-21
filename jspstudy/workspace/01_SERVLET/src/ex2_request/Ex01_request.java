package ex2_request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01_request
 */
@WebServlet("/Ex01_request")
public class Ex01_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex01_request() {
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
		
		
		//-------------request 객체정보살펴보기-------------//
		String ip = request.getRemoteAddr();  //중요
		String host =request.getRemoteHost();
		int port = request.getRemotePort();
		String contextPath = request.getContextPath(); //중요
		String charset = request.getCharacterEncoding();
		String contentType = request.getContentType();
		String method = request.getMethod();
		//-------------request 객체정보살펴보기------------//
		
		out.println("<h3>"+ip +"</h3>");
		out.println("<h3>"+host +"</h3>");
		out.println("<h3>"+port +"</h3>");
		out.println("<h3>"+contextPath +"</h3>");
		out.println("<h3>"+charset +"</h3>");
		out.println("<h3>"+contentType +"</h3>");
		out.println("<h3>"+method +"</h3>");
	
		
		
		
		out.println("</body>");
		out.println("</html>");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
