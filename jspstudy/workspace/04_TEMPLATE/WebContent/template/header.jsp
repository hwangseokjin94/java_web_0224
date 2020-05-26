<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    	request.setCharacterEncoding("utf-8");
    	String title =request.getParameter("title");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title %></title>
<style type="text/css">
	.head-menu{
		width : 100%;
		height: 150px;
		
		background :skyblue;
	}
	.main-menu{
		width : 1000px;
		height: 600px;
		margin: auto;
		background :lightgray;
	}
	.foot-menu{
	text-align: center;
	}
	
	ul {
		list-style-type: none;
		background: red;
		padding:0;
		display: flex;
	}
	
	ul > li {
	padding : 30px;
	}
	
	ul > li:hover{
	background: yellow;
	
	}
	
	
</style>
</head>
<body>
	<div class = "head-menu">
		<ul>
			<li>홈</li>
			<li>로그인</li>
			<li>방명록</li>
			<li>게시판</li>
		</ul>
	</div>