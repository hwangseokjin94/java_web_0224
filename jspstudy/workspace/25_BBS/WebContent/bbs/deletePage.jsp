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
	}
	.bbs-list-table {
		width: 500px;
		margin: auto;
		border-collapse: collapse;
	}
	.bbs-list-table td {
		font-size: 18px;
		font-family: '돋움', sans-serif;
		border: 1px solid black;
		padding: 5px 10px;
	}
	pre {
		font-size: 18px;
		font-family: '돋움', sans-serif;
	}
	.bbs-list-table td:nth-of-type(1) { width: 150px; text-align: center; }
	.bbs-list-table td:nth-of-type(2) { width: 350px; }
	textarea {
		width: 100%;
		padding: 5px;
	}
	label {
		display: inline-block;
		width: 100px;
	}
	.centered {
		text-align: center;
	}
	.title {
		margin: 10px 0;
	}
</style>
<script type="text/javascript">
	function fn_listPage(f) { 
		f.action = '/25_BBS/listPage.bbs';
		f.submit();
	}
	function fn_delete(f) {
		var bPw = '${bDTO.bPw}';
		if (bPw == f.bPw.value) {
			if (confirm('삭제할까요?')) {
				f.action = '/25_BBS/delete.bbs';
				f.submit();
			}
		}
	}	
</script>
</head>
<body>
	<div class="wrap">
		<h1 class="centered title">${bDTO.bNo } 번 게시물입니다.</h1>
		<form method="POST">
			<table class="bbs-list-table">
				<tbody>
					<tr>
						<td>삭제 비밀번호</td>
						<td><input type="password" name="bPw" /></td>
					</tr>
					<tr class="centered">
						<td colspan="2">
							<c:if test="${param.page eq null }">
								<input type="hidden" name="page" value="${page }" />
							</c:if>
							<c:if test="${param.page ne null }">
								<input type="hidden" name="page" value="${param.page }" />
							</c:if>
							<input type="button" value="게시물삭제하기" onclick="fn_delete(this.form)" />
							<input type="button" value="전체목록으로이동하기" onclick="fn_listPage(this.form)" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>