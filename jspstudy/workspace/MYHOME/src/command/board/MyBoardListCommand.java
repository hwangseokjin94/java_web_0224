package command.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import common.Command;
import common.PageMaker;
import dao.BoardDAO;
import dto.BoardDTO;
import dto.MemberDTO;

public class MyBoardListCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String page = request.getParameter("page");
		if (page == null || page.isEmpty()) {
			page = "1";
		}
		
		// page 를 알아야 가져올 list 의 begin 과 end 를 알 수 있다.
		int recordPerPage = 5;  // board, bbs, guestbook, member 등 모두 다른 값을 줄 수 있다.
		int beginRecord = (Integer.parseInt(page) - 1) * recordPerPage + 1;
		int endRecord = beginRecord + recordPerPage - 1;
		
		// beginRecord + endRecord = Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("beginRecord", beginRecord+"");
		map.put("endRecord", endRecord+"");
		
		//session에서올라간 MemberDTO 에서 mId꺼내서 Map에추가
		HttpSession session = request.getSession(); 
		MemberDTO loginDTO =(MemberDTO) session.getAttribute("loginDTO");
		String mId =loginDTO.getmId();				
		map.put("mId",mId);
		
		
		// DB에서 Mylist 가져오기
		List<BoardDTO> list = BoardDAO.getInstance().myBoardList(map);
		
		
		// 내 게시글 개수 구하기
		int totalRecord = BoardDAO.getInstance().getMyRecord(mId);
		
		
		// 페이지 생성 ( <<  1  2  3  >> )
		String pageView = PageMaker.getPageView("/MYHOME/myBoardListPage.board", Integer.parseInt(page), recordPerPage, totalRecord);
		
		
		// request 에 저장해서 전달할 데이터
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.setAttribute("totalRecord", totalRecord);
		request.setAttribute("pageView", pageView);
		
		
		//session 에 저장된 open 속성 삭제
		
		session.removeAttribute("open");
		
		
		// ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("/board/boardListPage.jsp");
		// setRedirect 를 안하면 forward 한다.
		
		return actionForward;
		
	}

}