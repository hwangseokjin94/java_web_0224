<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>성명</td>
				<td>전화</td>
				<td>주소</td>
				<td>이메일</td>
				<td>비고</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="6">연락처 없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="cDTO" items="${list}">
					<tr>
						<td>${cDTO.cNo}</td>
						<td><a href="contactViewPage?cNo=${cDTO.cNo}">${cDTO.cName}</a></td>
						<td>${cDTO.cPhone}</td>
						<td>${cDTO.cAddress}</td>
						<td>${cDTO.cEmail}</td>
						<td>${cDTO.cNote}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">
					<input type="button" value="새 연락처 등록" onclick="location.href='contactInsertPage'" />					
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>