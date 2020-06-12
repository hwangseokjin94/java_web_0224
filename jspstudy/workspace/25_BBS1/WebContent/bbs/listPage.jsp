<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!--fontawesome CDN  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
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
a{
color: black;
text-decoration: none;
}
</style>
</head>
<body>
 <div class="wrap">
 	<h1>BBS게시판</h1>
 	<br/>
 	<h3 id="w"><a href="/25_BBS/insertPage.bbs">BBS게시판작성하기</a></h3>
 	<br/><br/><br/>
 	
 	<table>
 		<thead>
 			<tr>
 			<th>순번</th>
 			<th>게시물번호번호</th>
 			<th>제목</th>
 			<th>작성자</th>
 			<th>작성일</th>
 			<th>조회수</th>
 			<th>첨부</th>
 			</tr> 			
 		</thead>
 		<tbody>
 		<c:if test="${empty LIST }">
 			<tr>
 				<td colspan="7">게시물이 없습니다.</td>
 			</tr>
 		</c:if>
 		<c:if test="${not empty LIST }">
 			<c:forEach varStatus="k" var="bDTO" items="${LIST }">
 			<tr>
 				<td>${pVO.totalRecord - ((pVO.page - 1)* pVO.recordPerPage + k.index) }</td>
 				<td>${bDTO.bNo }</td>
 				<td><a href="/25_BBS/viewPage.bbs?bNo=${bDTO.bNo }&page=${pVO.page}">${bDTO.bTitle }</a></td>
 				<td>${bDTO.bWriter }</td>
 				<td>${bDTO.bRegdate }</td>
 				<td>${bDTO.bHit }</td>
 				<td>
 					<c:if test ="${bDTO.bFilename ne null}">
 					<a href="/25_BBS/download.bbs?bFilename=${bDTO.bFilename}"><i class="fas fa-paperclip"></i></a>
 					</c:if>
				</td>

 			</tr>
 			
 			</c:forEach>
 		</c:if>
 		
 		</tbody>
 		<tfoot>
 		<tr>
 			<td colspan="7">
 			<!-- 1.이전페이지 버튼 -->
 			<c:if test="${pVO.beginBlock <= pVO.pagePerBlock}">
 				<span class ="disable">◀&nbsp;</span>
 			</c:if>
 			<c:if test="${pVO.beginBlock > pVO.pagePerBlock}">
 				<a href="/25_BBS/listPage.bbs?page=${pVO.beginBlock - 1}">◀&nbsp;</a>
 			</c:if>
 			<!-- 2.페이지 번호-->
 			<c:forEach var="p" begin="${pVO.beginBlock }" end="${pVO.endBlock }" step="1">
 				<c:if test="${p == pVO.page }">
 					<span class ="disable">${p }&nbsp;</span>
 				</c:if> 			
 				<c:if test="${p != pVO.page }">
 				<a href="/25_BBS/listPage.bbs?page=${p}">${p }&nbsp;</a>
 				</c:if> 			
 			</c:forEach>
 			<!-- 3.다음페이지 버튼 -->
 			<c:if test="${pVO.endBlock >= pVO.totalPage}">
 				<span class ="disable">▶&nbsp;</span>
 			</c:if>
 			<c:if test="${pVO.endBlock < pVO.totalPage}">
 				<a href="/25_BBS/listPage.bbs?page=${pVO.beginBlock + pVO.pagePerBlock}">▶&nbsp;</a>
 			</c:if>
 			</td>
 		</tr>
 		</tfoot>
 	</table>
 
 </div>
</body>
</html>