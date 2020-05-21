<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--JSP페이지로 action 이동하기  -->
	<!-- action="/컨텍스트 패스/JSP파일명.jsp  -->



	<form action = "/02_JSP/ex2_implicit_object/Ex01_to.jsp">
		이름 <input type = "text" name = "name"/><br/>
		나이 <input type = "text" name = "age"/><br/>
		<input type="submit" value="전송" />
		
	</form>
	
	<!--컨택스트패스는 request.getContextPath()로알아내서 변수로 처리할수있다.  -->
	<%
	String contextPath = request.getContextPath();   /* /02_JSP  */ 
	%>
	
	
	<form action="<%=contextPath %>/ex2_implicit_object/Ex01_to.jsp">
		자기소개 <br/>
		<textarea  name="info" rows="5" cols="10"></textarea>
		<input type="submit" value="전송" />
	</form>
</body>
</html>