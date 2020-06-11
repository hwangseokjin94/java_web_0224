package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletePageCommand implements GuesbookCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		request.setAttribute("no", request.getParameter("no"));
		request.setAttribute("pw", request.getParameter("pw"));
		
		ActionForward actionForward = new ActionForward();
		actionForward.setPath("/guestbook/deletePage.jsp");
		actionForward.setRedirect(false); //forward
		
		return actionForward;
	}

}
