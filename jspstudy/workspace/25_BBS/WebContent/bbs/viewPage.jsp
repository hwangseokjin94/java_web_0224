<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	background-color: #07592B;
	}
	.bbs-list-table {
		width: 500px;
		margin: auto;
		border-collapse: collapse;
		background-color:#F2D544;
	}
	.bbs-list-table td {
		font-size: 18px;
		font-family: '돋움', sans-serif;
		border: 1px solid black;
		padding: 5px 10px;
		background-color:#BFBFBF;
	}
	pre {
		font-size: 18px;
		font-family: '돋움', sans-serif;
		background-color:#D9A50B;
	}
	.bbs-list-table td:nth-of-type(1) { width: 150px; text-align: center; }
	.bbs-list-table td:nth-of-type(2) { width: 350px; }
	textarea {
		width: 100%;
		padding: 5px;
		background-color:#BF7E06;
	}
	label {
		display: inline-block;
		width: 100px;
		background-color:#BF7E06;
	}
	.reply-write {
		width: 500px;
		margin: auto;
		padding: 10px;
		background: lightgray;
	}
	.reply-list {
		width: 500px;
		margin: auto;
		padding: 10px;
	}
	.reply-list-table {
		border: 1px solid gray;
		width: 500px;
		margin: auto;
		border-collapse: collapse;
	}
	.reply-list-table td {
		padding: 20px;
		background-color:#F2D544;
	}
	.reply-list-table tr {
		border: 1px solid gray;
	}
	.centered {
		text-align: center;
	}
	.title {
		margin: 10px 0;
	}
</style>
<!-- fontawesome CDN -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<script type="text/javascript">
 	function fn_listPage(f) {
 		f.action='/25_BBS/listPage.bbs';
 		f.submit();
		
	}
</script>
</head>
<body>
	<div class="wrap">
		<h1 class="centered title" style="background-color:#F2D544;">${bDTO.bNo } 번 게시물입니다.</h1>
		<form method="POST">
			<table class="bbs-list-table">
				<tbody>
					<tr>
						<td>제목</td>
						<td>${bDTO.bTitle }</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${bDTO.bWriter }</td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td>
							<c:if test="${bDTO.bFilename eq null }">
								없음
							</c:if>
							<c:if test="${bDTO.bFilename ne null }">
								<a href="/25_BBS/download.bbs?bFilename=${bDTO.bFilename }">${bDTO.bFilename }</a>
							</c:if>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<pre>${bDTO.bContent }</pre>
						</td>
					</tr>
					<tr class="centered">
						<td colspan="2">
							<input type="hidden" name="page" value="${page }" />
							<input type="button" value="게시물수정하기" onclick="fn_updatePage(this.form)" />
							<input type="button" value="게시물삭제하기" onclick="fn_deletePage(this.form)" />
							<input type="button" value="전체목록으로이동하기" onclick="fn_listPage(this.form)" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	
		<br/><br/>
		<!-- 댓글 작성 창 -->
		<div class="reply-write">
			<form action="/25_BBS/insertReply.bbs" method="POST">
				<input type="submit" value="댓글 등록하기" /><br/><br/>
				<input type="hidden" name="bNo" value="${bDTO.bNo }" />  <!-- 댓글이 달릴 게시물의 번호가 필요하다. -->
				<input type="hidden" name="page" value="${page }" />
				<label>작성자</label>
				<input type="text" name="rWriter" /><br/>
				<label>비밀번호</label>
				<input type="password" name="rPw" /><br/><br/>
				<textarea name="rContent" rows="2" cols="50" placeholder="댓글은 마음의 창입니다."></textarea>
			</form>
		</div>
		
		<br/><br/>
		<!-- 댓글 목록 창 -->
		<div class="reply-list">
			<form method="POST">
				<table class="reply-list-table">
					<thead>
						<tr>
							<td>번호</td>
							<td>내용</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>삭제</td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty rList }">
							<tr>
								<td class="centered" colspan="5">댓글이 없습니다. 첫 댓글을 남겨 주세요.</td>
							</tr>
						</c:if>
						<c:if test="${not empty rList }">
							<c:forEach var="rDTO" items="${rList }">
								<tr>
									<td>${rDTO.rNo }</td>
									<td>${rDTO.rContent }</td>
									<td>${rDTO.rWriter }</td>
									<td><fmt:formatDate value="${rDTO.rRegdate }" pattern="yy/M/dd" /></td>
									<td>
										<a href="/25_BBS/deleteReply.bbs?rNo=${rDTO.rNo }&bNo=${bDTO.bNo}&page=${page}"><i class="fas fa-trash-alt"></i></a>
										<!-- rNo : 삭제할 댓글의 번호 -->
										<!-- bNo, page : 삭제 후 viewPage.jsp 로 돌아오기 위해 필요한 정보 -->
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</form>
		</div>
		
	</div>
</body>
</html>