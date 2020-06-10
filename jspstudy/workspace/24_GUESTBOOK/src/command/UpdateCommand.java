package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuestbookDAO;
import dto.GuestbookDTO;

public class UpdateCommand implements GuesbookCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		//request -> DTO
		GuestbookDTO gDTO = new GuestbookDTO();
		gDTO.setNo(Integer.parseInt(request.getParameter("no")));
		gDTO.setEmail(request.getParameter("email"));
		gDTO.setTitle(request.getParameter("title"));
		gDTO.setContent(request.getParameter("content"));
		
		int result = GuestbookDAO.getInstance().updateDTO(gDTO);
		ActionForward actionForward = new ActionForward();
		
		if(result >0) {
			//view에서 받는것이 파라미터이기때문에 보낼때도 파라미터로해야됨 setattribute로 못받는다.
			actionForward.setRedirect(false); //foward
			actionForward.setPath("/viewPage.guest?no="+request.getParameter("no"));
		}
		return actionForward;
	}

}
