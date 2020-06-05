package model;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Time {

	
	public String excuteTime(HttpServletRequest request,HttpServletResponse response) {
		
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		
				
		Date time = new Date();
				
		String time1 = format.format(time);
	
			
		
	
		request.setAttribute("TIME", time1);
		
		return"/view/output.jsp";
	}
}
