package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class English {

	
	public String  execute(HttpServletRequest request ,HttpServletResponse response) {
		request.setAttribute("RESULT", "HELLO~~~");
		return "output.jsp";
		
		
		
	}
	
}
