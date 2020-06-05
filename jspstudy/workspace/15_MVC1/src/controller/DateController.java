package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Today;

// CONTROLLER : JSP의 요청을 분석하여 처리할수있는 MODEL(순수 자바파일)을 호출한다.


@WebServlet("/DateController")
public class DateController extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 
    public DateController() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//일반저긍로 필요하다.
	 //request.setCharacterEncoding("utf-8");
	 //response.setContentType("text/html charset=utf-8");
		//모델호출
		Today date = new Today();
		String path = date.execute(request, response);
		//path이동
		//Today이 MODEL이 request에 결과를 저장했기때문에
		//request를 가지고 이동하는 방신ㄱ인 foward로 이동해야한다.
		request.getRequestDispatcher(path).forward(request,response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
