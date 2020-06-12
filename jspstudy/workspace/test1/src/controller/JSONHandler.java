package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

 
@WebServlet("/JSONHandler")
public class JSONHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JSONHandler() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String isMarried = request.getParameter("isMarried");
		
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("age", age);
		obj.put("isMarried", isMarried);
		
		request.setAttribute("obj", obj);
		
		request.getRequestDispatcher("/output.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		doGet(request, response);
	}

}
