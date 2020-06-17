package command.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.accessibility.internal.resources.accessibility;

import common.ActionForward;
import common.Command;
import dao.BoardDAO;
import dto.BoardDTO;

public class BoardInsertCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1.전달받은 파라미터 저장		
		request.setCharacterEncoding("utf-8");
		String bTitle =request.getParameter("bTitle");
		String bPw =request.getParameter("bPw");
		String bContent = request.getParameter("bContent");
		String mId =request.getParameter("mId");
		String bIp = request.getRemoteAddr();
		
		String page = request.getParameter("page");
		
		//2. bDTO 생성
		BoardDTO bDTO = new BoardDTO();
		bDTO.setmId(mId);
		bDTO.setbTitle(bTitle);
		bDTO.setbContent(bContent);
		bDTO.setbIp(bIp);
		bDTO.setbPw(bPw);
		
		//3.삽입
		int result= BoardDAO.getInstance().insertbDTO(bDTO);
		
		ActionForward actionForward = new ActionForward();
		if(result > 0 ) {
			actionForward.setPath("/MYHOME/boardListPage.board");
			actionForward.setRedirect(true);
		}else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out =response.getWriter();
			
			out.println("<script type='text/javascript'>");
			out.println("alert('게시글이 등록되지않았습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			
		}
		
		
		return actionForward;
	}

}
















