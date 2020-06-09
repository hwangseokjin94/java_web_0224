package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeesDAO;
import dto.EmployeesDTO;

public class DeptListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] department_id = request.getParameterValues("department_id");
		
		if(department_id == null || department_id.length == 0 ) {
			department_id = new String[1];
			department_id[0] = "10";
		}
		Map<String, String[]> map  = new HashMap<String, String[]>();
		map.put("department_id", department_id);
		
		List<EmployeesDTO> list = EmployeesDAO.getInstance().selectByDept(map);
		request.setAttribute("LIST", list);
		request.setAttribute("TYPE", "부서");
		return "result.jsp";
	}

}
