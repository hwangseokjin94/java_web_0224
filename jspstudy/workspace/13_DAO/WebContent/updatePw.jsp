<%@page import="com.sun.org.apache.bcel.internal.generic.BALOAD"%>
<%@page import="dao.BlueDao"%>
<%@page import="dto.BlueDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8"); 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	BlueDto bDto = new BlueDto();
	bDto.setId(id);
	bDto.setPw(pw);
	
	BlueDao bDao = BlueDao.getInstance();
	int result = bDao.updatePw(bDto);
			
	
	
	
	
	
	
		
		if( result > 0 ){
			out.println("<script>");
			out.println("alert('비밀번호가수정되었습니다.');");
			out.println("location.href='view.jsp?id="+id+"'");
			out.println("</script>");	
		}else{
			out.println("<script>");
			out.println("alert('비밀번호가수정않음. 다시시도하세요');");
			out.println("history.back()");
			out.println("</script>");			
		}
	
	
	
	
	
	
%>

