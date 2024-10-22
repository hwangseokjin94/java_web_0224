package ex1_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex04")
public class Ex04_response extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex04_response() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response 를 만든다.
		//1.content-type  과 charset을 결정한다.
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		// response.setContentType("text/html; charset=UTF-8");
		
		//2. 출력스트림을 response에 만든다.
		PrintWriter out =response.getWriter();
		
		//3. 출력스트림에 데이터를 추가한다.
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");		
		out.println("<title>나의 첫 서블릿 페이지</title>");
		out.println("<style>h1 {color :red;}</style>");
		out.println("<script> alert('경고창');</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>현재날짜와 시간 </h1>");
		
		//---------------현재 날짜와시간-----------//
	    Calendar calendar = Calendar.getInstance();
	    int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(calendar.MONTH)+1;
		int day = calendar.get(Calendar.DATE);
		int hour = calendar.get(calendar.HOUR_OF_DAY);
		int minute = calendar.get(calendar.MINUTE);
		//---------------현재 날짜와시간-----------//
		
		out.println("<h1>"+year +"년"+month+"월"+day+"일"+hour+":"+minute+"</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
