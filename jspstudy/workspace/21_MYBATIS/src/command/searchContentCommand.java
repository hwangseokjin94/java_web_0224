package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlackDAO;
import dto.BlackDTO;

public class searchContentCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String q = request.getParameter("q");
		List<BlackDTO> list = BlackDAO.getInstance().selectByContent(q);
		request.setAttribute("LIST", list);
		return"listPage.jsp";
	}

}
