package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.English;
import action.Korean;


@WebServlet("*.do")
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MVCController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//요청을 확인한다. (korean.do인지 english.do인지 확인한다.)
		//1.전체 요청을 알아낸다. /컨텍스트패스/*.do
		//2.컨텍스트 패스를알아낸다. /컨텍스트 패스
		//3.전체요청에서 컨텍스트패스를 뺀다. /*.do
		
		String requestURI = request.getRequestURI(); //     /16_MVC2/korean.do
		String contextPath = request.getContextPath();//    /16_MVC2
		String cmd = requestURI.substring(contextPath.length());//   /korean.do
		//String cmd = requestURI.substring(contextPath.length()+1);//   korean.do

		//각 MODEL이 리턴하는 응답VIEW를 저장할 변수를 선언한다.
		String path = null;
		
		//요청에따라 호출할 MODEL을 선택한다.
		switch (cmd) {
		case "/korean.do":
			Korean korean = new Korean();
			path = korean.execute(request, response);
			
			break;
		case "/english.do":
			English english = new English();
			path = english.execute(request, response);
			break;

		}
		
		//응답 VIEW로 이동한다. request에 결과저장되면 foward 결과가 없으면 redirect..?
		request.getRequestDispatcher(path).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
