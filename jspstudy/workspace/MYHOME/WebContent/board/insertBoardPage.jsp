<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/template/header.jsp">
	<jsp:param value="게시글작성" name="title" />
</jsp:include>

<style type="text/css">
	
	.board-insert-box {
	 
		margin: auto;
	}
	.board-insert-box table {
		border-collapse: collapse;
		width: 400px;
		margin: auto;
	}
	.board-insert-box table td {
		border: 1px solid black;
		padding: 5px;
	}
	.board-insert-box table td:nth-of-type(1) { width: 70px; }
	.board-insert-box table td:nth-of-type(2) { width: 500px; text-align: left}
	.board-insert-box table td:nth-of-type(3) { width: 100px; }
	.board-insert-box table td:nth-of-type(4) { width: 70px; }
	.board-insert-box table thead tr:nth-of-type(1) {
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
 	function fn_insertBoard(f) {
 		if(f.bTitle.value ==''){
 			alert('제목을 입력하세요');
 			f.bTitle.focus();
 			return;
 		}
 		
		f.action='/MYHOME/insertBoard.board';
		f.submit();
	}

</script>
<form method="POST">
<div class="board-insert-box">
	<table>
		<thead>
			<tr>				 
				<td colspan="2">새개시글작성</td>
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
					<input type="button" value="등록하기" onclick="fn_insertBoard(this.form)"/>
					<input type="reset" value="다시작성하기"/>					
					<input type="button" value="목록으로이동" onclick="location.href='/MYHOME/board/insertBoardPage.board'"/>
					<input type="hidden" name="page" value="${page}"/>					
					<input type="hidden" name="mId" value="${loginDTO.mId}"/>					
				</td>
			</tr>
		</tfoot>
	</table>
</div>
</form>

<%@ include file="/template/footer.jsp" %>
