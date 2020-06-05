package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MorningCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
			request.setAttribute("RESULT", "우유과자");
		return "output.jsp";
	}

}
