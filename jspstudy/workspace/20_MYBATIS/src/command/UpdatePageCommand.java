package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlackDAO;
import dto.BlackDTO;

public class UpdatePageCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("NO", request.getParameter("no"));
		
		
		return "updatePage.jsp";
	}

}
