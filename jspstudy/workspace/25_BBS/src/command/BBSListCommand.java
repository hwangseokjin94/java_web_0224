package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageVO;
import dao.BBSDAO;
import dto.BBSDTO;

public class BBSListCommand implements BBSCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1. PageVO 객체 생성
		PageVO pVO = new PageVO();
		
		// 2. 전체 레코드 개수 구하기
		pVO.setTotalRecord( BBSDAO.getInstance().selectTotalRecord() );
		
		// 3. 전체 페이지 개수 구하기
		pVO.setTotalPage();  // 전체 레코드 개수로 계산하는 공식이 PageVO 내부에 구현되어 있다.
		
		// 4. 현재 페이지 번호 구하기
		// PageVO 클래스에 page = 1 로 되어 있다. (파라미터가 없으면 1 페이지를 현재 페이지 번호로 사용한다.)
		// 파라미터가 있으면 전달된 파라미터가 페이지 번호가 된다.
		String page = request.getParameter("page");
		if ( page != null && !page.isEmpty() ) {
			pVO.setPage(Integer.parseInt(page));
		}
		
		// 5. 현재 페이지 번호에 따른 beginRecord, endRecord 구하기
		// recordPerPage = 3 에 의해서 계산된다.
		// page = 1,   beginRecord = 1   endRecord = 3
		// page = 2,   beginRecord = 4   endRecord = 6
		pVO.setBeginRecord( (pVO.getPage() - 1) * pVO.getRecordPerPage() + 1 );
		pVO.setEndRecord( pVO.getBeginRecord() + pVO.getRecordPerPage() - 1 );
		
		// 6. beginRecord ~ endRecord 사이의 list 만 가져오기
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRecord", pVO.getBeginRecord());
		map.put("endRecord", pVO.getEndRecord());
		
		List<BBSDTO> list = BBSDAO.getInstance().selectBBSList(map);
		request.setAttribute("LIST", list);
		
		// 7. beginBlock, endBlock 구하기
		// page = 1    beginBlock = 1    endBlock = 3 인데,
		// totalPage = 1 이라면 endBlock = 3 이 아니라, endBlock = 1(totalPage) 이어야 한다.
		pVO.setBeginBlock( ((pVO.getPage() - 1) / pVO.getPagePerBlock()) * pVO.getPagePerBlock() + 1 );
		pVO.setEndBlock( pVO.getBeginBlock() + pVO.getPagePerBlock() - 1 );
		
		// 8. endBlock 보정하기
		if ( pVO.getEndBlock() > pVO.getTotalPage() ) {
			pVO.setEndBlock( pVO.getTotalPage() );
		}

		// 9. listPage.jsp 에서 pVO 를 사용할 수 있도록 request 에 저장하기
		request.setAttribute("pVO", pVO);
		
		//10. bhit 처리를 위한 session정보 삭제하기
		//게시물의 목록을 가져오는 것은 게시물 보기의 종료를 의미한다.
		HttpSession session =request.getSession();
		String open = (String) session.getAttribute("open");
		if(open != null) { //게시물 보기상태였다면
			session.removeAttribute("open");
			
		}
		
		
		// 11. 이동		
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("/bbs/listPage.jsp");
		actionForward.setRedirect(false);  // request 전달을 위해 forward
		
		return actionForward;
		
	}

}
