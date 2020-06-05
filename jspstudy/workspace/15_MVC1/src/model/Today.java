package model;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Today {
	//MODEL:로직을 처리하고 , 로직의 결과와 결과를 보여줄 VIEW를 CONTROLLER에게 반환
	
	public String execute(HttpServletRequest request ,HttpServletResponse response) {
		
		//현재날짜구하기 
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DATE);
		String result = year+"-"+month+"-"+day;
		
		//MODEL은 2가지를 리턴한다.
		//1.결과
		//	 1)request의 속성으로 저장한다.
		//   2)session에 속성으로 저장한다.
		request.setAttribute("RESULT", result);
		
		
		
		//클래스타입은 래퍼런스타입~
		//2.결과를 보여줄 VIEW
		// 1)실제로 리턴 처리하는 부분이다.
		// 2) 어떤 JSP에서 결과를 보여줘야하는지 작성
		
		return "/view/output.jsp";
	} 
		
	
}
