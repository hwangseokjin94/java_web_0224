package ex2_request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex05_request")
public class Ex05_request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex05_request() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("utf-8");
		int kor = Integer.parseInt(request.getParameter("kor"));//name 을 전달받아야된다
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		
		double avg = (kor+eng+mat)/3.0;
		char grade =0;
		if(avg>=90) {grade='A';}
		else if(avg>=80) {grade='B';}
		else if(avg>=70) {grade='C';}
		else if(avg>=60) {grade='D';}
		else {grade='F';}
		
		
		
		String name = request.getParameter("name");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>request 정보</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<ul>");
		out.println("<li>이름 :"+name+"</li>");
		out.println("<li>국어점수 :"+kor+"</li>");
		out.println("<li>영어점수:"+eng+"</li>");
		out.println("<li>수학점수 :"+mat+"</li>");
		out.println("<li>평균 :"+avg+"</li>");
		out.println("<li>등급 :"+grade+"</li>");
		
		
		out.println("</ul>");

		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
