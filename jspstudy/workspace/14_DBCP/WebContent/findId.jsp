<%@page import="dto.WhiteDto"%>
<%@page import="dao.WhiteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 
 <%
 
 	request.setCharacterEncoding("utf-8");
 	String email = request.getParameter("email");
 	
 	WhiteDao wDao =WhiteDao.getInstance();
 	WhiteDto wDto = wDao.selectByEmail(email);
 	
 	pageContext.setAttribute("WDTO", wDto);/* EL JSTL을 사용을 하기위해서. */	
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1. email검색결과 없으면-->
	<c:if test="${WDTO eq null }">
		 일치하는 회원정보가 없습니다. 다시시도하세요 <br/><br/>
	 	<input type="button" value="다시찾기" onclick="history.back()"> 
	</c:if>
	<!--2.email 검색결과가 있으면   -->
	<c:if test="${WDTO ne null }">
		 검색된 아이디 :${WDTO.id}<br/><br/>
		 회원 가입 날짜 :${WDTO.reg_date}<br/><br/>
	 	<input type="button" value="로그인" onclick="location.href='loginPage.jsp'"/> 
	
	</c:if>

	
</body>
</html>