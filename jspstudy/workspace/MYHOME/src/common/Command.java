package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
