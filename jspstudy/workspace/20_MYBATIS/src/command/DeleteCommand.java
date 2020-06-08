package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlackDAO;
import dto.BlackDTO;

public class DeleteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		int no =Integer.parseInt(request.getParameter("no"));
		
		BlackDAO bDAO =BlackDAO.getInstance();
		int result =bDAO.delete(no);
		String path = null;
		if(result >0) {
			path ="listPage.do";
			//forward는 내부에서돌아서 컨택스트 패스 붙이면안된다...
		}else {
			path ="view.do?no="+no;
		}
		
		return path;
	}

}
