<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>성적처리 결과</h1>
<ul>
	<li>성명${DTO.name}</li>
	<li>국어${DTO.kor}</li>
	<li>영어${DTO.eng}</li>
	<li>수학${DTO.mat}</li>
	<li>평균${DTO.avg}</li>
	<li>학점${DTO.grade}</li>
	<li>평균 <fmt:formatNumber value="${DTO.avg }" pattern="0.00"/></li>
</ul>
</body>
</html>