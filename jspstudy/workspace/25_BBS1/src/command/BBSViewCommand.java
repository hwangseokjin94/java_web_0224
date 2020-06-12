package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;
import com.sun.xml.internal.ws.client.sei.SEIStub;

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
		
		//보여줄게시물
		BBSDTO bDTO = BBSDAO.getInstance().selectBBSBybNo(bNo);
		
		//보여줄게시물 정보는 session에 올려서 수정,삭제 에서 활용
		HttpSession session =request.getSession();
		session.setAttribute("bDTO", bDTO);
		
		//게시물에 달려있는 댓글 목록 가져오기
		List<ReplyDTO> rList = ReplyDAO.getInstance().selectReplyList(bNo);
		request.setAttribute("rList", rList);
		
		//게시물의 조회수 증가하기
		//게시물을 최초 View를 할떄 session 에 open 이라는 속성에 "yes라는 값을 저장해둔다.
		//session 에 open속성이 없으면 처음 열었다는거임..
		String open = (String)session.getAttribute("open");
		if(open == null) {
			session.setAttribute("open", "yes");
			// 1) 기존 bHit수 가져오기
			int bHit = bDTO.getbHit();
			//2) bHit수 증가시키기
			bDTO.setbHit(bHit+1); //bDTO 에 저장된 bNo와 bHit 로 update를 처리한다.
			//3)DB에 반영하기 (DAO의 updatebHit 호출)
			BBSDAO.getInstance().updatebHit(bDTO);
			
		}
		//현재페이지 번호 넘기기
		request.setAttribute("page",page);
		
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("/bbs/viewPage.jsp");
		actionForward.setRedirect(false); //forward page 리퀘스트할라공 ,,ㄴ
		
		
		return actionForward;
	}

}
