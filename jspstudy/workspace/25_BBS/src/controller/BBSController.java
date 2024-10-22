package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ActionForward;
import command.BBSCommand;
import command.BBSDeleteCommand;
import command.BBSInsertCommand;
import command.BBSListCommand;
import command.BBSUpdateCommand;
import command.BBSViewCommand;
import command.DownloadCommand;
import command.ReplyDeleteCommand;
import command.ReplyInsertCommand;

@WebServlet("*.bbs")
public class BBSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BBSController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 요청 확인 (*.bbs)
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		
		// ActionForward 선언
		ActionForward actionForward = null;
		
		// GuestbookCommand 선언
		BBSCommand command = null;
		
		// 요청(cmd)에 따른 Command 호출
		try {
			
			// Command 호출 및 이동방법 결정
			switch (cmd) {
			case "/listPage.bbs":
				command = new BBSListCommand();
				actionForward = command.execute(request, response);
				break;
			case "/download.bbs":
				DownloadCommand.download(request, response);
				break;
			case "/insert.bbs":
				command = new BBSInsertCommand();
				actionForward = command.execute(request, response);
				break;
			case "/viewPage.bbs":
				command = new BBSViewCommand();
				actionForward = command.execute(request, response);
				break;
			case "/insertReply.bbs":
				command = new ReplyInsertCommand();
				actionForward = command.execute(request, response);
				break;
			case "/update.bbs":
				command = new BBSUpdateCommand();
				actionForward = command.execute(request, response);
				break;
			case "/delete.bbs":
				command = new BBSDeleteCommand();
				actionForward = command.execute(request, response);
				break;
			case "/deleteReply.bbs":
				command = new ReplyDeleteCommand();
				actionForward = command.execute(request, response);
				break;
				
				
				
				
			// 단순 이동
			case "/insertPage.bbs":
				actionForward = new ActionForward();
				actionForward.setPath("/bbs/insertPage.jsp");
				break;
			case "/updatePage.bbs":
				actionForward = new ActionForward();
				actionForward.setPath("/bbs/updatePage.jsp");
				break;
			case "/deletePage.bbs":
				actionForward = new ActionForward();
				actionForward.setPath("/bbs/deletePage.jsp");
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