<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 1. 세션의 특정 값만 삭제하기
	// session.removeAttribute("DATA");

	// 2. 세션의 전체 값을 초기화하기
	session.invalidate();
	
	response.sendRedirect("Ex01_session1.jsp");
%>