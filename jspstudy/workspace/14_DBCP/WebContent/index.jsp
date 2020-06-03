<%@page import="dto.WhiteDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지에오신걸환영합니다.</h1>
<%	 WhiteDto wDto = (WhiteDto) session.getAttribute("USER");

	if(wDto != null){ %>
		<%=wDto.getName() %>님 반갑습니다.<button onclick="location.href='logout.jsp'">로그아웃</button>
	<%	
		 String id = wDto.getId();
	 	if(id.equals("admin")){
			//관리자%>
			<button onclick="location.href='list.jsp'">회원관리</button>
		<%
	 	}else{
	 		//일반유저 %>
			일반유저입니다.
		<%
	 	}
	}else{
		//로그인 정보 없음%>
		<button onclick="location.href='loginPage.jsp'">로그인</button>
		<%
	}
	
%>
	
</body>
</html>