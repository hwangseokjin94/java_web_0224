<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.wrap ,table,td,th{
border: 1px solid black;
padding: 10px;
margin: auto;
border-collapse: collapse;
width :500px;
text-align: center;
 
}
.wrap{
background-color: #07592B;
}
a,h1{
background-color:#F2D544;
}
th{
background-color:#BFBFBF;
}
td{
background-color:#D9A50B;
}
#w{
background-color:#BF7E06;
width: 250px;
height: 50px;
text-align: center;
margin: auto;
padding: 10px ;
}
.disable{
color: lighttray;
}
</style>
</head>
<body>
 <div class="wrap">
 	<h1>BBS게시판</h1>
 	<br/>
 	<h3 id="w"><a href="/25_BBS/insertPage.BBS">BBS게시판작성하기</a></h3>
 	<br/><br/><br/>
 	
 	<table>
 		<thead>
 			<tr>
 			<th>번호</th>
 			<th>제목</th>
 			<th>작성자</th>
 			<th>작성일</th>
 			<th>조회수</th>
 			</tr> 			
 		</thead>
 		<tbody>
 		<c:if test="${empty LIST }">
 			<tr>
 				<td colspan="5">게시물이 없습니다.</td>
 			</tr>
 		</c:if>
 		<c:if test="${not empty LIST }">
 			<c:forEach var="bDTO" items="${LIST }">
 			<tr>
 				<td>${bDTO.bNo }</td>
 				<td><a href="/25_BBS/viewPage.bbs?bNo=${bDTO.bNo }">${bDTO.bTitle }</a></td>
 				<td>${bDTO.bWriter }</td>
 				<td>${bDTO.bRegdate }</td>
 				<td>${bDTO.bHit }</td>

 			</tr>
 			
 			</c:forEach>
 		</c:if>
 		
 		</tbody>
 		<tfoot>
 		<tr>
 			<td colspan="5">
 			<!-- 1.이전페이지 버튼 -->
 			<c:if test="${pVO.beginBlock <= pVO.pagePerBlock}">
 				<span class ="disable">◀&npsp;</span>
 			</c:if>
 			<c:if test="${pVO.beginBlock > pVO.pagePerBlock}">
 				<a href="/25_BBS/listPage.bbs?page=${pVO.beginBlock - 1}">◀&npsp;</a>
 			</c:if>
 			<!-- 2.페이지 번호-->
 			<c:forEach var="p" begin="${pVO.beginBlock }" end="${pVO.endBlock }" step="1">
 				<c:if test="${p == pVO.page }">
 					<span class ="disable">${p }&npsp;</span>
 				</c:if> 			
 				<c:if test="${p != pVO.page }">
 				<a href="/25_BBS/listPage.bbs?page=${p}">${p }&npsp;</a>
 				</c:if> 			
 			</c:forEach>
 			<!-- 3.다음페이지 버튼 -->
 			<c:if test="${pVO.endBlock >= pVO.totalPage}">
 				<span class ="disable">▶&npsp;</span>
 			</c:if>
 			<c:if test="${pVO.endBlock < pVO.totalPage}">
 				<a href="/25_BBS/listPage.bbs?page=${pVO.beginBlock + pVO.pagePerBlock}">▶&npsp;</a>
 			</c:if>
 			</td>
 		</tr>
 		</tfoot>
 	</table>
 
 </div>
</body>
</html>