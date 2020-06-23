<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.context.support.AbstractApplicationContext"%>
<%@page import="com.koreait.mvc02.dto.PersonDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>view03.jsp입니다.</h1>
	<% 
	//root-context.xml에서 저장된 빈처리방법
	//root-context.xml에서 저장된 빈 은 applicationScop를 를가진다.
	WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);

	PersonDTO p1 = ctx.getBean("person1",PersonDTO.class);
	PersonDTO p2 = ctx.getBean("person2",PersonDTO.class);
	
	//EL(표현언어) 사용을 위해서 4가지영역중 한곳에 저장해야한다.
	pageContext.setAttribute("p1", p1);
	pageContext.setAttribute("p2", p2);
	
	
	
	
	%>
	<ul>
		<li>이름:${p1.name}</li>
		<li>나이:${p1.age}</li>
		<li>전화:${p1.contact.phone}</li>
		<li>이름:${p1.contact.addr}</li>
	</ul>
	<ul>
		<li>이름:${p2.name}</li>
		<li>나이:${p2.age}</li>
		<li>전화:${p2.contact.phone}</li>
		<li>이름:${p2.contact.addr}</li>
	</ul>

	
	
</body>
</html>