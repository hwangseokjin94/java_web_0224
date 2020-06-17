<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/template/header.jsp">
	<jsp:param value="댓글작성" name="title" />
</jsp:include>

<style type="text/css">
	
	.reply-insert-box {
	 
		margin: auto;
	}
	.reply-insert-box table {
		border-collapse: collapse;
		width: 400px;
		margin: auto;
	}
	.reply-insert-box table td {
		border: 1px solid black;
		padding: 5px;
	}
	.reply-insert-box table td:nth-of-type(1) { width: 70px; }
	.reply-insert-box table td:nth-of-type(2) { width: 500px; text-align: left}
	.reply-insert-box table td:nth-of-type(3) { width: 100px; }
	.reply-insert-box table td:nth-of-type(4) { width: 70px; }
	.reply-insert-box table thead tr:nth-of-type(1) {
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
  function fn_replyInsert(f) {
	  if(f.bTitle.value == ''){
		  alert('제목을 입력하세요');
		  f.bTitle.focus();
		  return;
	  }
	  f.action="/MYHOME/replyInsert.board";
	  f.submit();
  }
  function fn_boardListPage(f) {
	  f.action="/MYHOME/boardListPage.board";
	  f.submit();
	
}

</script>
<form method="POST">
<div class="reply-insert-box">
	<table>
		<thead>
			<tr>				 
				<td colspan="2">댓글작성</td>
			</tr>
		</thead>
		<tbody>
		 	<tr>
		 		<td>작성자</td>
		 		<td>${loginDTO.mId}</td>
		 	</tr>		 
		 	<tr>
		 		<td>제목</td>
		 		<td><input type="text" name="bTitle" autofocus/></td>	
		 	</tr>		 
		 	<tr>
		 		<td>비밀번호</td>
		 		<td><input type="password" name="bPw" autofocus/></td>	
		 	</tr>		 
		 	<tr>
		 		<td colspan="2">
		 			<textarea name="bContent" rows="10" cols="70" placeholder="내용"></textarea>
		 		</td>		 			
		 	</tr>		 		 			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input type="button" value="댓글등록하기" onclick="fn_replyInsert(this.form)"/>
					<input type="reset" value="다시작성하기"/>					
					<input type="button" value="목록으로이동" onclick="fn_boardListPage(this.form)"/>
					
					<input type="hidden" name="page" value="${page}"/>					
					<input type="hidden" name="mId" value="${loginDTO.mId}"/><!--  작성자-->					
					<input type="hidden" name="bNo" value="${bNo}"/> <!-- 잿글이달리는 게시글번호 -->
				</td>
			</tr>
		</tfoot>
	</table>
</div>
</form>

<%@ include file="/template/footer.jsp" %>
