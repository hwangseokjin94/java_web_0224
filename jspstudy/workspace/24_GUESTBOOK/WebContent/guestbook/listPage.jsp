<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.wrap{
border: 1px solid black;
padding: 10px;
margin: auto;
border-collapse: collapse;

}
</style>
</head>
<body>
 <div class="wrap">
 	<h1>방명록</h1>
 	<br/>
 	<a href="/24_GUESTBOOK/insertPage.guest">방명록 작성하기</a>
 	<br/><br/><br/>
 	<form action="/24_GUESTBOOK/selectQuery.guest">
 		<input type="text" name="query" placeholder="제목 +내용"/>
 		<input type="submit" value="검색"/>
 		
 		
 	</form>
 	<table>
 		<thead>
 			<tr>
 			<th>번호</th>
 			<th>제목</th>
 			<th>작성자</th>
 			<th>작성일</th>
 			</tr> 			
 		</thead>
 		<tbody>
 		<c:if test="${empty LIST }">
 			<tr>
 				<td colspan="4">방명록이 없습니다.</td>
 			</tr>
 		</c:if>
 		<c:if test="${not empty LIST }">
 			<c:forEach var="gDTO" items="${LIST }">
 			<tr>
 				<td>${gDTO.no }</td>
 				<td><a href="/24_GUESTBOOK/viewPage.guest?no=${gDTO.no }">${gDTO.title }</a></td>
 				<td>${gDTO.writer }</td>
 				<td>${gDTO.regdate }</td>

 			</tr>
 			
 			</c:forEach>
 		</c:if>
 		
 		</tbody>
 	</table>
 
 </div>
</body>
</html>