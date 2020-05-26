<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% request.setCharacterEncoding("utf-8"); %>
	
	<jsp:useBean id="p" class="bean.Person" />
	<%--
		id="별명"
		class="패키지.클래스"
		scope="생명주기"
		1) scope="page" : 현재 페이지에서만 사용할 수 있다. (기본값)
		2) scope="request"
		3) scope="session"
		4) scope="application"
		
		Person p = new Person();
	--%>
	
	
	<jsp:setProperty property="*" name="p" />
	<%--
		property="*" : 모든 프로퍼티(필드)값을 저장하라.
		
		p.setName(request.getParameter("name"));
		p.setAge(request.getParameter("age"));
		p.setHeight(request.getParameter("height"));
		p.setGender(request.getParameter("gender"));
	--%>
	
	<ul>
		<li>이름: <jsp:getProperty property="name" name="p"/></li>
		<li>나이: <jsp:getProperty property="age" name="p"/></li>
		<li>키: <jsp:getProperty property="height" name="p"/></li>
		<li>성별: <jsp:getProperty property="gender" name="p"/></li>
	</ul>
	<%--
		p.getName();
		p.getAge();
		p.getHeight();
		p.getGender();
	--%>
	

</body>
</html>










