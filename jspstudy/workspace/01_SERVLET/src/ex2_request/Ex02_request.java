package ex2_request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex02_request")
public class Ex02_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public Ex02_request() {
        super();

    }

	/* 
	 * 	request 에 전잘된 요청 정보 처리하기
	 * 			1. request 에 저장된 요청 정보는 "parameter" 라고 부른다.
	 * 			2. 모든 "parameter"의 타입은 String 또는 String[]
	 * 			3. "parameter"가 String타입인 경우
	 * 				String value = request.getParameter("parameter");
	 * 			4."parameter" 가  String[]타입인경우
	 * 				String[] list= request.getParameterValues("parameter");
	 *			5.request 에 요청 정보 전달하기
	 *				1) <form>태그의 submit을 실행하면 모든 폼요소의 값이 전달된다.
	 *				2) URL에 "parameter"직접 추가한다.
	 *
	 *http://localhost:9090/01_SERVLET/Ex02_request?name=애말리&age=20&address=경기도 성남시  
	 *  */
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
