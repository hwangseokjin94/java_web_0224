package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.DeleteCommand;
import command.InsertCommand;
import command.InsertPageCommand;
import command.ListCommand;
import command.UpdateCommand;
import command.UpdatePageCommand;
import command.ViewCommand;
 
@WebServlet("*.do")
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MyController() {
        super();
        
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.setCharacterEncoding("utf-8");
	 String requestURI = request.getRequestURI();
	 String contextPath = request.getContextPath();
	 String cmd = requestURI.substring(contextPath.length());
	
	 Command command =null;
	 switch(cmd) {
	 case "/insert.do":
		 command = new InsertCommand();
		 break;
	 case "/listPage.do":
		 command = new ListCommand();
	     break;
	     
	 case "/insertPage.do":
		 command = new InsertPageCommand();
		 break;
	 case "/view.do":
		  command = new ViewCommand();
		 break;
	 case "/delete.do":
		 command = new DeleteCommand();
		 break;
	 case "/updatePage.do":
		 command = new UpdatePageCommand();
		 break;
	 case "/update.do":
		 command = new UpdateCommand();
		 break;
	 }	 
	String path = command.execute(request, response);
	 request.getRequestDispatcher(path).forward(request, response);
	// 
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
