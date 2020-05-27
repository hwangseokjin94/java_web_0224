<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String data = request.getParameter("data");
	
	// data 를 session 에 저장하기
	session.setAttribute("DATA", data);
	
	// session 에 저장된 정보를 확인하기 위해 페이지 이동하기
	response.sendRedirect("Ex01_session1.jsp");
%>