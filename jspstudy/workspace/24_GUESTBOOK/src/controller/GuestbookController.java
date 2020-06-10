package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ActionForward;
import command.GuesbookCommand;
import command.InsertCommand;
import command.ListCommand;
import command.UpdateCommand;
import command.ViewCommand;


@WebServlet("*.guest")
public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GuestbookController() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//요청확인 "*.guest"
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		
		//ActionForward 선언
		ActionForward actionForward = null;
		
		//GuestbookCommand선언
		GuesbookCommand command = null;
		try {
			
			//Command호출 및 이동방법결정
			switch (cmd) {
			case "/listPage.guest":
				command = new ListCommand();
				actionForward = command.execute(request, response);
				break;
				
			//단순 페이지의 이동은 Command가 필요없다.
			//actionForward 는 응답 View +이동방법 으로 구성된다.	
			case "/insertPage.guest":
				
				actionForward = new ActionForward();
				actionForward.setPath("/24_GUESTBOOK/guestbook/insertPage.jsp");
				actionForward.setRedirect(true); //redirect (넘겨줄 request가 없는경우) redirect로 넘길때컨텍스트 루트 붙여야됨
				
				break;
				
			case "/insert.guest":
				command = new InsertCommand();
				actionForward = command.execute(request, response);				
				break;
				
			case "/viewPage.guest":
				command = new ViewCommand();
				actionForward = command.execute(request, response);				
				break;
				
			case "/update.guest":
				command = new UpdateCommand();
				actionForward = command.execute(request, response);				
				break;
				
			default:
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
