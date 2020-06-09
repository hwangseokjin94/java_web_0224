package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeesDAO;
import dto.EmployeesDTO;

public class DynamicListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String column =request.getParameter("column");
		String query =request.getParameter("query");
		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("query", query);
		
		List<EmployeesDTO> list = EmployeesDAO.getInstance().selectByDynamic(map);
		request.setAttribute("LIST", list);
		request.setAttribute("TYPE", "동적");	
		return "result.jsp";
	}

}
