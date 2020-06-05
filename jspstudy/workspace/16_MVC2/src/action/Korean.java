package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Korean {

	
	public String  execute(HttpServletRequest request ,HttpServletResponse response) {
		request.setAttribute("RESULT", "안녕하세요");
		return "output.jsp";
		
		
		
	}
	
}
