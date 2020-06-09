package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import dao.EmployeesDAO;
import dto.EmployeesDTO;

public class EmpListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<EmployeesDTO> list = EmployeesDAO.getInstance().selectList();
		request.setAttribute("LIST", list);
		request.setAttribute("TYPE", "전체");
		return "result.jsp";
		
	}

}
