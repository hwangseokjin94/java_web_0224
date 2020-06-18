package command.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import common.Command;
import dao.BoardDAO;
import dto.BoardDTO;

public class BoardDeleteCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1. 전달받은 파라미터저장
		request.setCharacterEncoding("utf-8");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String page = request.getParameter("page");
		
		//2. 삭제 상태의 bDTO생성
		//   1) bDelete : -1		
		BoardDTO bDTO = new BoardDTO();
		bDTO.setbDelete(-1);		
		bDTO.setbNo(bNo);
		
		//3.삭제 (실제로는 업데이트
		
		int result =BoardDAO.getInstance().deletebDTO(bDTO);
		ActionForward actionForward = new ActionForward();
				
		if(result>0){
			actionForward.setPath("/MYHOME/boardListPage.board?page="+page);
			actionForward.setRedirect(true);
		}else{
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out =response.getWriter();			
			out.println("<script type='text/javascript'>");
			out.println("alert('게시글이 삭제되지않았습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			
		}
		
		return actionForward;
	}

}
