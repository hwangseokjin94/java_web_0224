package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GuesbookCommand {
 
	public ActionForward execute(HttpServletRequest request , HttpServletResponse response)throws Exception;
	
}
