package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.board.BoardDeleteCommand;
import command.board.BoardInsertCommand;
import command.board.BoardListCommand;
import command.board.BoardViewCommand;
import command.board.MyBoardListCommand;
import command.board.QueryBoardListCommand;
import command.board.ReplyInsertCommand;
import common.ActionForward;
import common.Command;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 요청 확인 (*.board)
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
			case "/boardListPage.board":
				command = new BoardListCommand();
				actionForward = command.execute(request, response);
				break;
			
			case "/insertBoard.board":
				command = new BoardInsertCommand();
				actionForward = command.execute(request, response);
				break;
			case "/boardViewPage.board":
				command =new BoardViewCommand();				
				actionForward = command.execute(request, response);
				break;
			case "/replyInsert.board":
				command = new ReplyInsertCommand();		
				actionForward = command.execute(request, response);
				break;
						
			case "/boardDelete.board":
				command = new BoardDeleteCommand();		
				actionForward = command.execute(request, response);
				break;
				
			case "/myBoardListPage.board":
				command = new MyBoardListCommand();
				actionForward = command.execute(request, response);
				break;
			case "/QueryBoardListPage.board":
				command = new QueryBoardListCommand();
				actionForward = command.execute(request, response);
				break;
				
			
			//단순이동
			case "/insertBoardPage.board":
				actionForward = new ActionForward();				
				actionForward.setPath("/board/insertBoardPage.jsp");
				break;
		
			case "/replyInsertPage.board":
				actionForward = new ActionForward();				
				actionForward.setPath("/board/replyInsertPage.jsp");
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