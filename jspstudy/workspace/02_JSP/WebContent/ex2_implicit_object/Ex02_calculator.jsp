<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String n1 = "";
	String n2 = "";
	String result = "";
	
	if ( request.getParameter("n1") != null &&
		 request.getParameter("n2") != null ) {
		
		String op = request.getParameter("op");
		n1 = request.getParameter("n1");
		n2 = request.getParameter("n2");
		double v1 = Double.parseDouble(n1);
		double v2 = Double.parseDouble(n2);
		
		switch (op) {
		case "+": result = (v1 + v2) + ""; break;
		case "-": result = String.valueOf(v1 - v2); break;
		case "*": result = (v1 * v2) + ""; break;
		case "/": result = (v1 / v2) + ""; break;
		}
		
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>계산기</h3>
	<form action="/02_JSP/ex2_implicit_object/Ex02_calculator.jsp">
		<input type="text" name="n1" value="<%=n1 %>" size="5" />
		<select name="op">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select>
		<input type="text" name="n2" value="<%=n2 %>" size="5" />
		<input type="submit" value="=" />
		<input type="text" name="result" value="<%=result %>" size="7" />
	</form>
	
</body>
</html>












