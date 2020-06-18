package command.board;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import common.Command;
import dao.BoardDAO;
import dto.BoardDTO;

public class ReplyInsertCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1전달되는 파라미터
		request.setCharacterEncoding("utf-8");
		String bTitle =request.getParameter("bTitle");
		String mId =request.getParameter("mId");
		String bContent =request.getParameter("bContent");
		String bPw =request.getParameter("bPw");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String bIp =request.getRemoteAddr();
		
		String page =request.getParameter("page");
		
		//.2.replyDTO생성
		BoardDTO replyDTO = new BoardDTO();
		replyDTO.setmId(mId);
		replyDTO.setbTitle(bTitle);
		replyDTO.setbContent(bContent);
		replyDTO.setbPw(bPw);
		replyDTO.setbIp(bIp);
		
		//3.bDTO 가져오기 (원글 가저오기 댓글이달릴)
		// 레퍼런스가 같으면 한게시글에 달리고 depth에 따라서 0보다크면 니들은 댓글이구나.........
		
		BoardDTO bDTO = BoardDAO.getInstance().selectBybNo(bNo);
		
		//4.bDTO (원글) 정보로 replyDTO(댓글) 정보채우기
		replyDTO.setbRef(bDTO.getbRef());
		replyDTO.setbDepth(bDTO.getbDepth()+1);
		replyDTO.setbStep(bDTO.getbStep()+1);
		
				
		//댓글이추가되는경우 기존댓글만 bStep값을 1씩 증가시킨다.
		//5. 기존 댓글들의 bStep값을 1씩증가시키기
		//가장오래된(가장먼저달린) 댓글의 bStep값이 가장 커진다. (내린차순 정렬로 가장 위로 올릴수 있다.)
		
		BoardDAO.getInstance().updatebStep(bDTO);
		
		//6.replyDTO저장
		
		int result= BoardDAO.getInstance().insertReplyDTO(replyDTO);
		ActionForward actionForward = new ActionForward();
		if(result>0) {
			actionForward.setPath("/MYHOME/boardListPage.board?page="+page);
			actionForward.setRedirect(true);
		}else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out =response.getWriter();
			
			out.println("<script type='text/javascript'>");
			out.println("alert('댓글이 등록되지않았습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();			
		}
		return actionForward;
	}

}
