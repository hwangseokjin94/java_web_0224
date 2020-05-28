<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL:표현 언어</h3>
	<ul>
		<li>${"제임스"}</li>
		<li>${'앨리스'}</li>
		<li>${100 }</li>
		<li>${1.5 }</li>
		<li>${true }</li>
		<li>${null }</li>
		<li>${10+20}</li>
	</ul>
	<%-- <%= %>이거의 대채품 --%>
	
	<h3>JSP 표현식</h3>
	<ul>
		<li>7 + 2 = <%=7+2  %></li>
		<li>7 - 2 = <%=7-2  %></li>
		<li>7 * 2 = <%=7*2  %></li>
		<li>7 % 2 = <%=7%2  %></li>
		<li>7 / 2 = <%=7/2  %></li>
	</ul>
	
	
	<h3>EL 표현언어</h3>
	<ul>
		<li>7 + 2 = ${7+2 }</li>
		<li>7 - 2 = ${7-2 }</li>
		<li>7 * 2 = ${7*2 }</li>
		<li>7 % 2 = ${7%2 }</li>
		<li>7 / 2 = ${7/2 }</li>
	</ul>
	
	
	
	<h3>표현식과 표현언어의 변수 값 사용</h3>
	<% int a = 100; %>
	표현식:<%=a %><br/>
	<%  pageContext.setAttribute("a", a);   %>	
	표현언어 :${a }<br/>
	
	<h3>4가지 영역의 우선 순위 확인</h3>
	<%
		//pageContext > request > session > application
		pageContext.setAttribute("CAR", "S60");
		request.setAttribute("CAR", "S90");
		session.setAttribute("CAR", "XC60");
		application.setAttribute("CAR", "XC90");
		
	%>
	자동차 모델 확인 ${CAR} <br/>
	
	
	<h3>4가지 영역의 변수 호출 방식</h3>
	<ul>
		<li> ${pageScope.CAR }</li>
		<li> ${requestScope.CAR }</li>
		<li> ${sessionScope.CAR }</li>
		<li> ${applicationScope.CAR }</li>
	</ul>
	
	
	
</body>
</html>














