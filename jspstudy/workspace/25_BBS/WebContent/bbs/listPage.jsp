<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	.wrap {
		width: 760px;
		margin: auto;
		text-align: center;
		background-color: #07592B;
	}
	.wrap table {
		width: 650px;
		min-height: 150px;
		margin: auto;
		border-collapse: collapse;
		background-color:#F2D544;
	}
	th, td {
		border: 1px solid black;
		padding: 3px 5px;
		background-color:#BFBFBF;
	}
	td:nth-of-type(1) { width: 50px; }
	td:nth-of-type(2) { width: 250px; }
	td:nth-of-type(3) { width: 100px; }
	td:nth-of-type(4) { width: 150px; }
	input {
		padding: 5px;
	}
	input[type=text] {
		width: 400px;
		height: 30px;
	}
	input[type=submit] {
		width: 100px;	
		height: 30px;
	}
	a {
		color: black;
		text-decoration: none;
	}
	.centered {
		text-align: center;
	}
	.title {
	background-color:#D9A50B;
		margin: 10px 0;
	}
	.disable {
		color: lightgray;
	}
</style>
<!-- fontawesome CDN -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
</head>
<body>
	<div class="wrap">
		<h1 class="title">BBS 게시판</h1>
		<br/>
		<a href="/25_BBS/insertPage.bbs">BBS 게시판 작성하기</a>
		<br/><br/><br/>
		<table>
			<thead>
				<tr>
					<th>순번</th>
					<th>게시물번호</th>
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
						<td colspan="7">BBS 게시물이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty LIST }">
					<c:forEach varStatus="k" var="bDTO" items="${LIST }">
						<tr>
							<td>${pVO.totalRecord - ((pVO.page - 1) * pVO.recordPerPage + k.index) }</td>
							<td>${bDTO.bNo }</td>
							<td><a href="/25_BBS/viewPage.bbs?bNo=${bDTO.bNo }&page=${pVO.page}">${bDTO.bTitle }</a></td>
							<td>${bDTO.bWriter }</td>
							<td>${bDTO.bRegdate }</td>
							<td>${bDTO.bHit }</td>
							<td>
								<c:if test="${bDTO.bFilename ne null }">
									<a href="/25_BBS/download.bbs?bFilename=${bDTO.bFilename }"><i class="fas fa-paperclip"></i></a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7">
						<!-- 1. 이전 페이지 버튼 -->
						<c:if test="${pVO.beginBlock <= pVO.pagePerBlock }">
							<span class="disable">◀&nbsp;</span>
						</c:if>
						<c:if test="${pVO.beginBlock > pVO.pagePerBlock }">
							<a href="/25_BBS/listPage.bbs?page=${pVO.beginBlock - 1 }">◀&nbsp;</a>
						</c:if>
						<!-- 2. 페이지 번호 -->
						<c:forEach var="p" begin="${pVO.beginBlock }" end="${pVO.endBlock }" step="1">
							<c:if test="${p == pVO.page }">
								<span class="disable">${p }&nbsp;</span>
							</c:if>
							<c:if test="${p != pVO.page }">
								<a href="/25_BBS/listPage.bbs?page=${p }">${p }&nbsp;</a>
							</c:if>
						</c:forEach>
						<!-- 3. 다음 페이지 버튼 -->
						<c:if test="${pVO.endBlock >= pVO.totalPage }">
							<span class="disable">▶</span>
						</c:if>
						<c:if test="${pVO.endBlock < pVO.totalPage }">
							<a href="/25_BBS/listPage.bbs?page=${pVO.beginBlock + pVO.pagePerBlock }">▶</a>
						</c:if>
					</td>
				</tr>
			</tfoot>
		</table>		
	</div>
</body>
</html>