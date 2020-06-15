package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.member.LoginCommand;
import command.member.LogoutCommand;
import common.ActionForward;
import common.Command;

@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 요청 확인 (*.member)
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		
		// ActionForward 선언
		ActionForward actionForward = null;
		
		// Command 선언
		Command command = null;
		
		// 요청(cmd)에 따른 Command 호출
		try {
			
			// Command 호출 및 이동방법 결정
			switch (cmd) {
			
			// 단순이동
			case "/loginPage.member":
				actionForward = new ActionForward();
				actionForward.setPath("/member/loginPage.jsp");
				break;
			case "/findIdPage.member":
				actionForward = new ActionForward();
				actionForward.setPath("/member/findIdPage.jsp");
				break;
			
			case "/login.member":
				command = new LoginCommand();
				actionForward = command.execute(request, response);
				break;
			case "/logout.member":
				command = new LogoutCommand();
				actionForward = command.execute(request, response);
				break;
				
			}
				
			// 결정된 이동방법으로 이동
			if ( actionForward != null ) {
				if ( actionForward.isRedirect() ) {  // 리다이렉트 이동이면,
					response.sendRedirect( actionForward.getPath() );
				} else {  // 포워드이면,
					request.getRequestDispatcher( actionForward.getPath() ).forward(request, response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}