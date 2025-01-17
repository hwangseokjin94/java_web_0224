package ex2_request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex04_request")
public class Ex04_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Ex04_request() {
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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String[] hobbies =request.getParameterValues("hobbies");
		String address = request.getParameter("address");
		String[] jobs= request.getParameterValues("jobs");
		String memo = request.getParameter("memo");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");

		
		out.println("<ul>");
		out.println("<li>아이디 :"+id+"</li>");
		out.println("<li>비밀번호 :"+pw+"</li>");
		out.println("<li>성별 :"+gender+"</li>");
		if(hobbies==null) {
			out.println("<li>취미없음</li>");
		}else {
			out.println("<li>"+Arrays.toString(hobbies)+"</li>");
			
		}
		out.println("<li>주소 :"+address+"</li>");
		if(jobs ==null ) {
			out.println("<li>직업:[없음]</li>");
		}else {
			out.println("<li>"+Arrays.toString(jobs)+"</li>");
			
		}
		
		
		out.println("<li><pre>메모 :"+memo+"</pre></li>");
		out.println("<li>키 :"+height+"</li>");
		out.println("<li>몸무게 :"+weight+"</li>");
		
		out.println("</ul>");
		
		//--요청정보를 request 에서 꺼내기
		
	
		
		out.println("</body>");
		out.println("</html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
