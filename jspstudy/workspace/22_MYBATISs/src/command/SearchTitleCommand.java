package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeesDAO;
import dto.EmployeeDTO;

public class SearchTitleCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String q = request.getParameter("q");
		
		List<EmployeeDTO> list = EmployeesDAO.getInstance().selectByTitle();
				
		request.setAttribute("LIST", list);
		
		
		return "listPage.jsp";
	}

}
