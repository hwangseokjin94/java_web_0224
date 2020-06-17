<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/template/header.jsp">
	<jsp:param value="게시판" name="title" />
</jsp:include>

<style type="text/css">
	
	.board-list-box {
		width: 600px;
		margin: auto;
	}
	.board-list-box table {
		border-collapse: collapse;
		width: 600px;
		margin: auto;
	}
	.board-list-box table td {
		border: 1px solid black;
		padding: 5px;
	}
	.board-list-box table td:nth-of-type(1) { width: 300px; }
	.board-list-box table td:nth-of-type(2) { width: 100px; }
	.board-list-box table td:nth-of-type(3) { width: 100px; }
	.board-list-box table td:nth-of-type(4) { width: 70px; }
	.board-list-box table thead tr:nth-of-type(1) {
		text-align: center;
		font-weight: bold;
		background-color: white;
	}
	.lefted{
	text-align: left;
	font-weight:bold;
	color:crimson;
	margin-bottom: 5px;
	}
</style>

<div class="board-list-box">
	<!-- 로그인하면 게시글을 작성할수있다. -->
	<c:if test="${loginDTO ne null }">
		<input type="button" value="새 게시글 작성하기" onclick="location.href='/MYHOME/insertBoardPage.board?page=${page}'"/>
		<input type="button" value="내 게시글 보기" onclick="location.href='/MYHOME/myBoardListPage.board?page=${page}'"/>		
	</c:if>
	
	<br/><br/>
	
	<div class="lefted">  전체개시글${totalRecord}개</div>
	<table>
		<thead>
			<tr>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">작성된 게시글이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="bDTO" items="${list}">
					<tr>
						<td>
							<!-- 1.댓글과 원의 구분을위하여 bDepth만큼 들여쓰기를 한다. -->
							<c:forEach begin="1" end="${bDTO.bDepth}" step="1">
								&nbsp;&nbsp;
							</c:forEach>
							<!-- 2.댓글은 제목앞에 [Re]를 붙인다. -->
							<c:if test="${bDTO.bDepth ne 0}">
								[Re]&nbsp;
							</c:if>
							<a href="/MYHOME/boardViewPage.board?bNo=${bDTO.bNo}&page=${page}">${bDTO.bTitle}</a>
						</td>
						<td>${bDTO.mId}</td>
						<td>${bDTO.bRegdate}</td>
						<td>${bDTO.bHit}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">${pageView}</td>
			</tr>
		</tfoot>
	</table>
</div>

<%@ include file="/template/footer.jsp" %>