package command.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import common.Command;
import dao.BoardDAO;
import dto.BoardDTO;

public class BoardViewCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//1.전달받은 파라미터
		request.setCharacterEncoding("utf-8");
				
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String page = request.getParameter("page");
		
		
		//2.bDTO읽어오기
		BoardDTO bDTO = BoardDAO.getInstance().selectBybNo(bNo);
		
		//3.히트수증가
		HttpSession session =request.getSession();
		String open = (String)session.getAttribute("open");
		if(open == null) {
			session.setAttribute("open", "yes");
			BoardDAO.getInstance().updatebHit(bNo);
		}
		
		//request로 전달할 데이터
		request.setAttribute("page",page);
		request.setAttribute("bDTO", bDTO);
		
		ActionForward actionForward= new ActionForward();
		if(bDTO != null) {
			actionForward.setPath("/board/boardViewPage.jsp");
			
		}else {		
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out =response.getWriter();
			
			out.println("<script type='text/javascript'>");
			out.println("alert('게시글 정보를 확인할수없습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();

		}
			
		return actionForward;
	}

}
