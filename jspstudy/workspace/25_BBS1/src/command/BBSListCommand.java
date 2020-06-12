package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageVO;
import dao.BBSDAO;
import dto.BBSDTO;

public class BBSListCommand implements BBSCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1Page 객체 생성
		PageVO pVO = new PageVO();
		
		//2.전체레코드 개수처리
		pVO.setTotalRecord(BBSDAO.getInstance().selectTotalRecord());
		
		// 3.전체 페이지 개수구하기
		pVO.setTotalPage(); //전체 레코드로 개수로 계산하는 공식이 PageVo내부에 구현되어있다.
		
		//4.현재 페이지 번호 구하기
		//PageVO클래스에 page =1로 되어있다. (파라미터가없으면 1페이지를 현재페이지번호로 사용한다.)
		//파라미터가 있으면 전달된 파라미터가 페이지 번호가 된다.
		String page = request.getParameter("page");
		if( page != null && !page.isEmpty() ){
			pVO.setPage(Integer.parseInt(page));
		}
		
		//5.현재페이지 번호에따른 beginRecord ,endRecord 구하기
		// recordPerPage= 3에의해서 계산된다.
		//page= 1, beginRecord =1 endRecord =3
		//page= 2, beginRecord =4 endRecord =6
		pVO.setBeginRecord( (pVO.getPage()-1 * pVO.getRecordPerPage()+1));
		pVO.setEndRecord(pVO.getBeginRecord()+pVO.getRecordPerPage()-1);
		
		//6.beginRecord ~endRecord 사이의 list만 가져오기
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRecord", pVO.getBeginRecord());
		map.put("endRecord", pVO.getEndRecord());
		
		//7. beginBlock  endBlock구하기
		//page =1,2,3  beginBlock = 1     endBlock = 3 인데 
		//totalPage =1 이라면 endBlock =3 이 아니라 endBlock = 1(totalpage) 이어야 한다.
		
		pVO.setBeginBlock( ((pVO.getPage()-1) / pVO.getPagePerBlock()) * pVO.getPagePerBlock()+1 );
		pVO.setEndBlock( pVO.getBeginBlock()+pVO.getPagePerBlock()-1 );
		
		//endBlock 보정하기
		if(pVO.getEndBlock() > pVO.getTotalPage() ){
			pVO.setEndBlock( pVO.getTotalPage() );
		}
		//9. listPage 에서 pVO를 사용할수있도록 requeset
		request.setAttribute("pVO", pVO);
		
		List<BBSDTO> list = BBSDAO.getInstance().selectBBSList(map);
		request.setAttribute("LIST", list);
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("/bbs/listPage.jsp");
		actionForward.setRedirect(false); //request전달을 위해forward
		
		return actionForward;
	}

}
