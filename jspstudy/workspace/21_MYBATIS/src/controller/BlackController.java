package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.SearchBothCommand;
import command.SearchTitleCommand;
import command.searchContentCommand;

 
@WebServlet("*.do")
public class BlackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public BlackController() {
        super();
     

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	String requestURI = request.getRequestURI();
	String contextPaht =request.getContextPath();
	String cmd = requestURI.substring(contextPaht.length());
	Command command = null;
	
	switch (cmd) {
		case "/searchTitle.do":
			command = new SearchTitleCommand();
			break;
		case "/searchContent.do":
			command = new searchContentCommand();
			break;
		case "/searchBoth.do":
			command = new SearchBothCommand();
			break;
		case "/listPage.do":
			
			break;
	
	}
	String path = command.execute(request, response);
	request.getRequestDispatcher(path).forward(request, response);
	
	
	
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		doGet(request, response);
	}

}
