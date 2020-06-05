package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gugudan {

	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		
		String strDan =request.getParameter("dan");
		if(strDan == null || strDan.isEmpty()) {
			strDan="2";
		}
		request.setAttribute("DAN", strDan);
		StringBuffer sb = new StringBuffer();
		
		
		int dan = Integer.parseInt(strDan);
		
		
		for(int i=1 ;i <10;i++) {
			sb.append(dan + "x"+i+"="+(i*dan)+"<br/>");
			
			  
		}
		
		request.setAttribute("RESULTGU", sb.toString());
		
		
		
		
		return"/view/output3.jsp";
	}
	
	
	
}
