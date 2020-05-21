<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
     	int a = 10;
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//1.JSP 변수는 JavaScript 에서 사용할수있다.
	var js_a = '<%=a%>';
	alert(js_a);
	
	//2. JavaScript 변수는 JSP에서 사용할수없다.
	var js_b = 10;
	
</script>
</head>
<body>
	<!--사용불가  -->
	<%--  <%= js_b%> --%>
</body>
</html>