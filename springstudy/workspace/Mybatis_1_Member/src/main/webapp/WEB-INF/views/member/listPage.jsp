<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>이름</td>
		</tr>
		<c:forEach var="mDTO" items="${list}">
			<tr>
				<td>${mDTO.mNo}</td>
				<td><a href="viewPage?mNo=${mDTO.mNo}">${mDTO.mId}</a></td>
				<td>${mDTO.mName}</td>
			</tr>		
		</c:forEach>
			<tr>
				<td colspan="3">
					<input type="button" value="가입하기" onclick="location.href='insertPage'">
				</td>
			</tr>		
	</table>
</body>
</html>