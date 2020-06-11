package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ActionForward;
import command.BBSCommand;
import command.BBSListCommand;


@WebServlet("*.bbs")
public class BBSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BBSController() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//요청확인 "*.bbs"
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		
		//ActionForward 선언
		ActionForward actionForward = null;
		
		//GuestbookCommand선언
		BBSCommand command = null;
		try {
			
			//Command호출 및 이동방법결정
			switch (cmd) {
			case "/listPage.bbs":
				command = new BBSListCommand();
				actionForward = command.execute(request, response);
				break;
				
			}
			//결정된 이동방법으로 이동
			if(actionForward != null ) {
				if(actionForward.isRedirect()) {//리다이랙트이동이면
					response.sendRedirect(actionForward.getPath());
				}else {//포어드이면
					request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
