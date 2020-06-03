<%@page import="dao.BlueDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	
	BlueDao bDao = BlueDao.getInstance();
		out.println("<script>");
	if ( bDao.idCheck(id) ){
		out.println("alert('사용가능한 아이디입니다.');");
		out.println("location.href='insertPage.jsp?id="+id+"&chk=true'");
	}else{
		out.println("alert('사용불가능한 아이디입니다.');");
		out.println("history.back()");
	}
	out.println("</script>");
	%>