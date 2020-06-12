<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel= "stylesheet" type="text/css" href="co.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<style type="text/css">
h1{

color: red;
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
<div class="wrap">
		<h1>${bDTO.bNo }번 게시물입니다</h1>
		<form method="POST">			
			<table>
				<tbody>
					<tr>
						<td>제목</td>
						<td>${bDTO.bTitle }</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${bDTO.bWriter}</td>
					</tr>								
					<tr>
						<td>첨부파일</td>
						<td>
						<c:if test="${bDTO.bFilename eq null}">
							없음
						</c:if>
						<c:if test="${bDTO.bFilename ne null}">
							<a href="/25_BBS/download.bbs?bFilename=${bDTO.bFilename }">${bDTO.bFilename}</a>
						</c:if>
							
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<pre>${bDTO.bContent}</pre>
						</td>					
					</tr>
					<tr>
						<td colspan="2">
							<input type="hidden" name="page" value="${page}"/>							
							<input type="button" value="게시물 수정하기" onclick="fn_updatePage(this.form)"/>
							<input type="button" value="게시물 삭제하기" onclick="fn_deletePage(this.form)"/>																				
							<input type="button" value="전체목록으로 이동하기" onclick="location.href='/25_BBS/listPage.bbs'"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form>	
	</div>
	
	<br/><hr/><br/>
	<!--댓글작성창  -->
	<div class="reply-write">
		<form action="/25_BBS/insertReply.bbs" method="POST">
			<input type="submit" value="댓글등록하기"/><br/>
			<input type="hidden" name="bNo" value="${bDTO.bNo}"/><!-- 댓글이달릴 게시물의 번호가 필요하다.-->
			<input type="hidden" name="page" value="${page}"/>	
			<label>작성자</label>
			<input type ="text" name="rWriter"/><br/>
			<label>비밀번호</label>
			<input type ="password" name="rPw"/><br/>
			<textarea name="rContent" rows="2" cols="50" placeholder="댓글은 마음의창입니다."></textarea>
		</form>
	</div>
	
	<br/><hr/><br/>
	<!--댓글목롱창  -->
	<div class="reply-list">
		<form method="POST">
			<table>
				<thead>
					<tr>
						<td>댓글번호</td>
						<td>작성자</td>
						<td>내용</td>
						<td>작성일</td>
						<td>삭제</td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty rList }">
						<tr>
							<td colspan="5">댓글이 없습니다.</td>
						</tr>
					</c:if>
					
					<c:if test="${not empty rList}">
						<c:forEach var="rDTO" items="${rList }">
							<tr>
								<td>${rDTO.rNo }</td>
								<td>${rDTO.rWriter }</td>
								<td>${rDTO.rContent }</td>
								<td>${rDTO.rRegdate }</td>
								<td>
									<a href="/25_BBS/deleteReply.bbs?rNo=${rDTO.rNo }&bNo=${bDTO.bNo }&$page=${page}"><i class="fas fa-trash-alt"></i></a>
									<!-- rNo:삭제할 댓글의 번호 -->
									<!-- bNo ,page :삭제후 viewPage.jsp로 돌아오기 위해 필요한 정보-->
								</td>							
							</tr>
						</c:forEach>
					</c:if>
					
				</tbody>
			</table>			
		</form>
	
	
	
	</div>
	
	
	
</body>
</html>