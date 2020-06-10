package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuestbookDAO;
import dto.GuestbookDTO;

public class ListCommand implements GuesbookCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward actionForward = new ActionForward();
		
		List<GuestbookDTO> list = GuestbookDAO.getInstance().selectList();
		request.setAttribute("LIST", list);
		
		actionForward.setPath("/guestbook/listPage.jsp");
		actionForward.setRedirect(false); //forward
		
		return actionForward;
	}

}
