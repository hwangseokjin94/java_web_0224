<%@page import="dto.BlueDto"%>
<%@page import="dao.BlueDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!--1)파라미터 4개를 1개의 DTO로 만든다. 
 	2)DAO의 update()메소드를 호출한다.
 	3)결과에따라 스크립트를 처리한다.
 	DAO의 update()메소드
 	1)매개변수 : DTO
 	2)리턴타입 : int
  -->   
    
<%
		
		request.setCharacterEncoding("utf-8");
		
		
		BlueDto bDto = new BlueDto();
		bDto.setId(request.getParameter("id"));
		bDto.setPw(request.getParameter("pw"));
		bDto.setName(request.getParameter("name"));
		bDto.setAge(Integer.parseInt(request.getParameter("age")));
		bDto.setEmail(request.getParameter("email"));
		
		BlueDao bDao = BlueDao.getInstance();
		int result = bDao.update(bDto);
		
		if( result > 0 ){
			out.println("<script>");
			out.println("alert('업되이트됨되었습니다.');");
			out.println("location.href='view.jsp?id="+request.getParameter("id")+"'");
			out.println("</script>");	
		}else{
			out.println("<script>");
			out.println("alert('업되이트되지않음. 다시시도하세요');");
			out.println("history.back()");
			out.println("</script>");			
		}
		
  %>    
