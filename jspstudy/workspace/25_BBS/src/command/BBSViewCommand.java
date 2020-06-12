package command;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BBSDAO;
import dao.ReplyDAO;
import dto.BBSDTO;
import dto.ReplyDTO;

public class BBSViewCommand implements BBSCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String page = request.getParameter("page");
		
		// 보여 줄 게시물
		BBSDTO bDTO = BBSDAO.getInstance().selectBBSBybNo(bNo);
		
		// 보여 줄 게시물 정보는 session 에 올려서 수정, 삭제에서 활용한다.
		HttpSession session = request.getSession();
		session.setAttribute("bDTO", bDTO);
		
		// 게시물에 달려 있는 댓글 목록 가져오기
		List<ReplyDTO> rList = ReplyDAO.getInstance().selectReplyList(bNo);
		request.setAttribute("rList", rList);
		
		// 게시물의 조회수 증가하기
		// 게시물을 최초 View 할 때 session 에 open 이라는 속성에 "yes" 라는 값을 저장해 둔다.
		// session 에 open 속성이 없으면 처음 열었다는 의미이다.
		String open = (String) session.getAttribute("open");
		if (open == null) {
			session.setAttribute("open", "yes");
			// 1) 기존 bHit 수 가져오기
			int bHit = bDTO.getbHit();
			// 2) bHit 수 증가시키기
			bDTO.setbHit(bHit + 1);  // bDTO 에 저장된 bNo 와 bHit 로 update 를 처리한다.
			// 3) DB에 반영 (BBSDAO의 updatebHit() 호출)
			BBSDAO.getInstance().updatebHit(bDTO);
		}
		
		// 현재 페이지 번호 넘기기
		request.setAttribute("page", page);
		
		ActionForward actionForward = new ActionForward();
		
		if (bDTO != null) {
			actionForward.setPath("/bbs/viewPage.jsp");
			actionForward.setRedirect(false);  // forward
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('게시물을 불러올 수 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return actionForward;
		
	}

}