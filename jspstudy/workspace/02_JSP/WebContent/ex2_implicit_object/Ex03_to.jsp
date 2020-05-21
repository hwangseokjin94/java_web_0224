<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String gender = request.getParameter("gender");
	String[] hobbies = request.getParameterValues("hobbies");
	String etc = request.getParameter("etc");
	String address = request.getParameter("address");
	String[] jobs = request.getParameterValues("jobs");
	String memo = request.getParameter("memo");
	String height = request.getParameter("height");
	String weight = request.getParameter("weight");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>개인정보</h3>
	<ol>
		<li>아이디: <%=id %></li>
		<li>비밀번호: <%=pw %></li>
		<li>성별: <%=gender %></li>
		<li>
			<% if ( hobbies != null ) { %>
				취미<br/>
				<ul>
					<% for ( String hobby : hobbies ) { %>
						<li><%=hobby %></li>
					<% } %>
					<% if ( etc != null ) { %>
						<li><%=etc %></li>
					<% } %>
				</ul>
			<% } else { %>
				취미 없음
				<%} %>
		</li>
		<li>주소: <%=address %> </li>
		<li>직업 : <%=Arrays.toString(jobs) %> </li>
		<li>메모: <%=memo %> </li>
		<li>키: <%=height %> </li>
		<li>몸무게: <%=weight %> </li>
		
	</ol>
	

</body>
</html>











