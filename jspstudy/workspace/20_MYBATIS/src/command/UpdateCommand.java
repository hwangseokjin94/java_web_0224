package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlackDAO;
import dto.BlackDTO;

public class UpdateCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
		request.setCharacterEncoding("utf-8");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		BlackDTO bDTO = new BlackDTO();
		bDTO.setNo(Integer.parseInt(request.getParameter("no"))); 
		bDTO.setTitle(request.getParameter("title"));
		bDTO.setContent(request.getParameter("content"));
		
		BlackDAO bDAO = BlackDAO.getInstance();
		bDAO.update(bDTO);
		
		return "view.do?no="+request.getParameter("no");
	}

}
