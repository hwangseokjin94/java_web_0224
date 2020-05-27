<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		User user = new User();
		user.setId(id);
		user.setPw(pw);
		
		session.setAttribute("USER", user);
		
	
	%>
	<h1><%=((User)session.getAttribute("USER")).getId()%> 님 반값습니다. </h1>
	
	
	<br/><br/><br/>
	
	<form action="Ex03_cart3.jsp" method="post">
		<h3>상품을 선택하세요</h3>
		<select name ="product">
			<option value="짬뽕볶음밥">짬뽕볶음밥</option>
			<option value="해물몪음밥">해물몪음밥 </option>
			<option value="김치볶음밥">김치볶음밥 </option>
			<option value="짜장볶음밥">짜장볶음밥</option>
			<option value="카레볶음밥">카레볶음밥</option>		
		</select>
		<input type="text" name ="quantity" size="3"/>개
		<br/>	<br/>	<br/>
		<input type= "submit" value="장바구니에 추가"/>
		<input type="button" value="구매하기" onclick="location.href='Ex03_cart4.jsp'"/>
		<input type="button" value="로그아웃" onclick="location.href='Ex03_cart5.jsp'"/>
	</form>
	
</body>
</html>