package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuestbookDAO;
import dto.GuestbookDTO;

public class SelectQueryCommand implements GuesbookCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String query = request.getParameter("query");
		
		List<GuestbookDTO> list = GuestbookDAO.getInstance().selectByQuery(query);
		request.setAttribute("LIST", list);		
		
		
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("/guestbook/listPage.jsp");
		actionForward.setRedirect(false); //forward
		
		return actionForward;
		
	}

}
