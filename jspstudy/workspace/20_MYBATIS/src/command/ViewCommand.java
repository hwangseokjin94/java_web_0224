package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlackDAO;
import dto.BlackDTO;

public class ViewCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int no =Integer.parseInt(request.getParameter("no"));
		
		BlackDAO bDAO = BlackDAO.getInstance();
		BlackDTO bDTO = bDAO.selectOne(no);
		request.setAttribute("BDTO", bDTO);
		
		return "view.jsp";
	}

}
