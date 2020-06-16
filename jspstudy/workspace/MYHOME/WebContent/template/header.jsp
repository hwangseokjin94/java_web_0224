<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	if (title == null || title.isEmpty()) {
		title = "환영합니다";
	}
	pageContext.setAttribute("title", title);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<style>
	*{
		padding:0;
		margin: 0;
		font-family: 'Jua', sans-serif;
	}
	.wrap, .header-wrap, .main-wrap, .footer-wrap{
		box-sizing: border-box;
		width: 600px;
		text-align: center;
		margin: auto;
			background: rgb(42,193,188);
	}
	.header-wrap{
	border: 1px solid black;
		text-align: right;
		padding: 20px;
	}
	
	 .footer-wrap{
		border: 1px solid black;
		padding: 20px;
		
	}
	.wrap{
		margin: auto;
	}
	.main-wrap{
		width: 600px;
		padding: 50px;
		 height: 600px;
	}
	a{
	text-decoration: none;
	color:black;
	}
	body{
	background:  rgb(42,135,124); 
	
	}
	tr,td{
	border: 1px solid black;
	
	}
	
</style>

<!-- jquery -->
<script type="text/javascript" src="assets/lib/jquery-3.5.1.js"></script>
<script type="text/javascript">
	function fn_logout() {
		if (confirm('로그아웃 하시겠습니까?')) {
			location.href = '/MYHOME/logout.member';
		}
	}
	function fn_leave() {
		if (confirm('회원탈퇴 하시겠습니까?')) {
			location.href = '/MYHOME/leavePage.member';
		}
	}
</script>
</head>
<body>
	
	<div class="wrap">
		<div class="header-wrap">
			
			<!-- 1. 로그인이 안 된 상태에서 처리할 작업 -->
			<c:if test="${loginDTO eq null}">
				<input type="button" value="로그인" onclick="location.href='/MYHOME/loginPage.member'" />
				<input type="button" value="회원가입" onclick="location.href='/MYHOME/signUpPage.member'" />      
			</c:if>
			
			
			<!-- 2. 로그인이 된 상태에서 처리할 작업 -->
			<c:if test="${loginDTO ne null}">
				${loginDTO.mName} 님 반갑습니다&nbsp;&nbsp;
				<input type="button" value="로그아웃" onclick="fn_logout()" />
				<input type="button" value="회원탈퇴" onclick="fn_leave()" />
			</c:if>
			
			
		</div>
		<div class="main-wrap">
		
		
		
		
		
		
		
		
		
		
		
		