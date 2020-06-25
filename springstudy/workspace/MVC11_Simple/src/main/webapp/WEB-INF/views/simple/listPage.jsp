<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="wrap">
		<table border="1">
			<thead>
				<tr>
					<td>번호</td>
					<td>작성자</td>
					<td>제목</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="sDTO" items="${list}">
					<tr>
						<td>${sDTO.bNo }</td>
						<td>${sDTO.bWriter }</td>
						<!--href="view" @RequestMappint("view")를의미한다.  -->
						<!-- href="view?bNo=${sDTO.bNo }" bNo파라미터를 전달한다.-->  
						<td><a href="view?bNo=${sDTO.bNo }">${sDTO.bTitle}</a></td>
						<td>${sDTO.bDate }</td>
					</tr>
				</c:forEach>
			</c:if>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<input type="button" value="새글작성하기" onclick="location.href='insertPage'">
						<!--  onclick="location.href='insertPage'" 는 @RequestMapping("insertPage")을의미한다. -->
					</td>					
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>