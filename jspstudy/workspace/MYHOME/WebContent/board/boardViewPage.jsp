<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/template/header.jsp">
	<jsp:param value="게시글보기" name="title" />
</jsp:include>

<style type="text/css">
	
	.board-view-box {
	 
		margin: auto;
	}
	.board-view-box table {
		border-collapse: collapse;
		width: 400px;
		margin: auto;
	}
	.board-view-box table td {
		border: 1px solid black;
		padding: 5px;
	}
	.board-view-box table td:nth-of-type(1) { width: 70px; }
	.board-view-box table td:nth-of-type(2) { width: 500px; text-align: left}
	.board-view-box table td:nth-of-type(3) { width: 100px; }
	.board-view-box table td:nth-of-type(4) { width: 70px; }
	.board-view-box table thead tr:nth-of-type(1) {
		text-align: center;
		font-weight: bold;
		background-color: white;
		font-size: 50px;
	}
	.lefted{
	text-align: left;
	font-weight:bold;
	color:crimson;
	margin-bottom: 5px;
	}
	input[name=bTitle],input[name=bPw]{
	 color:blue;
	}
</style>
<script type="text/javascript">
	//댓글작성페이지로 이동
	function fn_replyInsertPage(f) {
		f.action ='/MYHOME/replyInsertPage.board';
		f.submit();
	}
	//
	function fn_boardDelete(f) {
		var bPw='${bDTO.bPw}'
		if(f.bPw.value =='' ){
			alert('삭제비밀번호를 입력하세요');
			f.bPw.focus();
			return;
		}
		
		if(f.bPw.value !=bPw ){
			alert('비밀번호를 확인하세요');
			f.bPw.focus();
			return;
		}
		
		f.action='/MYHOME/boardDelete.board';
		f.submit();
	}

</script>
<form method="POST">
<div class="board-view-box">
	<table>
		<thead>
			<tr>				 
				<td colspan="2">${bDTO.bNo}번게시물 </td>
			</tr>
		</thead>
		<tbody>
		 	<tr>
		 		<td>작성자</td>
		 		<td>${bDTO.mId}</td>
		 	</tr>		 
		 	<tr>
		 		<td>제목</td>
		 		<td>${bDTO.bTitle}</td>	
		 	</tr>		 
		 	<tr>
		 		<td>작성일</td>
		 		<td>${bDTO.bRegdate}</td>	
		 	</tr>		 
		 	<tr>
		 		<td>조회수</td>
		 		<td>${bDTO.bHit}</td>	
		 	</tr>		 
		 	<tr>
		 		<td>작성IP</td>
		 		<td>${bDTO.bIp}</td>	
		 	</tr>		 
		 	<tr>
		 		<td colspan="2">
		 			<pre>${bDTO.bContent}</pre>
		 		</td>		 			
		 	</tr>		 		 			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">		
					<!-- 로그인을 해야만글을 쓸수있다.원글에만 댓글을 달수 있다. -->
					<c:if test="${loginDTO ne null and bDTO.bDepth eq 0 }">
						<input type="button" value="댓글달기" onclick="fn_replyInsertPage(this.form)"/>
					</c:if>
												
					<input type="button" value="목록으로이동" onclick="location.href='/MYHOME/boardListPage.board?page=${page}'"/>
					&nbsp;&nbsp;&nbsp;
					
					<!--로그인을 해야만 글을 삭제할수 있다. -->
					<c:if test="${loginDTO ne null}">
						<input type="button" value="삭제하기" onclick="fn_boardDelete(this.form)"/>
						삭제비밀번호<input type="password" name ="bPw" size="5" />
					</c:if>
					
					<input type="hidden" name="page" value="${page}"/>					
					<input type="hidden" name="bNo" value="${bDTO.bNo}"/>					
				</td>
			</tr>
		</tfoot>
	</table>
</div>
</form>

<%@ include file="/template/footer.jsp" %>
