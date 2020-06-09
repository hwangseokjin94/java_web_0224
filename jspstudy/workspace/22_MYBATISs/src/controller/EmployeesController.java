package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.SearchTitleCommand;


@WebServlet("*.do")
public class EmployeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmployeesController() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		String contextPath =request.getContextPath();
		String cmd= requestURI.substring(contextPath.length());
		Command command = null;
		try {
			switch (cmd) {
			case "/searchTitle.do":
				command = new SearchTitleCommand();
				break;

			default:
				break;
			}
			String path = command.execute(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
