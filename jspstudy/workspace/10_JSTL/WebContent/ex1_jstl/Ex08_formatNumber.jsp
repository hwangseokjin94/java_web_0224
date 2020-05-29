<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="n" value="12345678.123456789"/>
	
	<ul>
		<li>쉼표 +소수 3자리 디폴트 : <fmt:formatNumber value="${n }"/></li>
		<li>쉼표엄ㅄ애기 : <fmt:formatNumber value="${n }" groupingUsed="false"/></li>
		

		<li>쉼표+정수  : <fmt:formatNumber value="${n }" pattern="#,##0"/></li>
		<li>쉼표+소수 1자리  : <fmt:formatNumber value="${n }" pattern="#,##0.0"/></li>
		<li>쉼표+소수 2자리  : <fmt:formatNumber value="${n }" pattern="#,##0.00"/></li>
		
		<li>정수  : <fmt:formatNumber value="${n }" pattern="0"/></li>
		<li>정수 +소수1자리 : <fmt:formatNumber value="${n }" pattern="0.0"/></li>
		<li>정수 +소수2자리 : <fmt:formatNumber value="${n }" pattern="0.00"/></li>
		

		<li>퍼센트(1==100%) : <fmt:formatNumber value="0.5" type="percent"/></li>
		
		<li>통화(원화): <fmt:formatNumber value="${n }" type="currency"/></li>
		<li>통화(달러): <fmt:formatNumber value="${n }" type="currency" currencySymbol="$"/></li>
		
		
		
	</ul>
</body>
</html>