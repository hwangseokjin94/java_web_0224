package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

public class test implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		obj.put("pw", pw);
		
		request.setAttribute("obj", obj);
		

		
		return "output.jsp";
	}

}



