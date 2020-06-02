<%@page import="dao.BlueDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    	request.setCharacterEncoding("utf-8");
    	String id = request.getParameter("id");
		
    	BlueDao bDao = BlueDao.getInstance();
    	int result = bDao.delete(id);
    	
   	if( result > 0 ){
		out.println("<script>");
		out.println("alert('탈퇴되었습니다.');");
		out.println("location.href='list.jsp'");
		out.println("</script>");	
	}else{
		out.println("<script>");
		out.println("alert('탈퇴되지않았습니다.');");
		out.println("history.back()");
		out.println("</script>");
	}	
		
  %>
