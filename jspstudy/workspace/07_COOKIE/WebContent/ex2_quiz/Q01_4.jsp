<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String birthYear = request.getParameter("birthYear");
	String birthMonth = request.getParameter("birthMonth");
	String birthDay = request.getParameter("birthDay");
	String birthday = birthYear+"년"+ birthMonth +"월"+ birthDay+"일";
	
	String marriage = request.getParameter("marriage");
	String marriage2 = marriage.equals("yes") ? "기혼":"미혼";
	
	String job = request.getParameter("job");
	
	response.addCookie(new Cookie("BIRTHDAY",URLEncoder.encode(birthday,"utf-8")) ) ;
	response.addCookie(new Cookie("MARRIAGE",URLEncoder.encode(marriage2,"utf-8")) );
	response.addCookie(new Cookie("JOB",URLEncoder.encode(job,"utf-8")) );
	
	response.sendRedirect("Q01_5.jsp");
%>    
    