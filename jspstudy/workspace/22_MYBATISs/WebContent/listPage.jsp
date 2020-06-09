<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class ="wrap">
	
		<table border="1">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>내용</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty LIST }">
					<tr>
						<td colspan="4">데이터가없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty LIST }">
					<c:forEach var="eDTO" items="${LIST }">
					<tr>
					<td>${eDTO.employee_id }</td>										
				
					</tr>
					</c:forEach>
				</c:if>
			</tbody>
			
			
			
		</table>
	
	</div>
</body>
</html>