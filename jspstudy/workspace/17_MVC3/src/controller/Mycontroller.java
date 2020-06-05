package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Command;
import action.EveningCommand;
import action.LunchCommand;
import action.MorningCommand;

 
@WebServlet("*.do")
public class Mycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Mycontroller() {
        super();
         
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI =request.getRequestURI();
		String contextPath =request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		
		//자식은 부모에 저장할수있다 Command부모고  아침 점심 저녁 이 자식  
		//인터페이스 Command는 모든 MODEL들의 저장타입이다.
		Command command = null;
		switch(cmd) {
		case "/morning.do":
			command = new MorningCommand();
			break;
		case "/lunch.do":
			command = new LunchCommand();
			break;
		case "/evening.do":
			command = new EveningCommand();
			break;
		}
		
		String path = command.execute(request, response);
		request.getRequestDispatcher(path).forward(request, response);
		
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		doGet(request, response);
	}

}
