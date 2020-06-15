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
	function fn_update(f) {
		// 비밀번호 체크
		var bPw = '${bDTO.bPw}';
		if ( bPw != f.bPw.value ) {
			alert('비밀번호를 확인하세요.');
			f.bPw.focus();
			return;
		}
		f.action = '/25_BBS/update.bbs';
		f.submit();
	}
	function fn_listPage(f) { 
		f.action = '/25_BBS/listPage.bbs';
		f.submit();
	}
</script>
</head>
<body>
	<div class="wrap">
		<h1 class="centered title">${bDTO.bNo } 번 게시물입니다.</h1>
		<form method="POST" enctype="multipart/form-data">
			<table class="bbs-list-table">
				<tbody>
					<tr>
						<td>제목</td>
						<td><input type="text" name="bTitle" value="${bDTO.bTitle }" /></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="bWriter" value="${bDTO.bWriter }" readonly /></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="bPw" />
					</tr>
					<tr>
						<td>첨부파일</td>
						<td>
							<input type="file" name="bFilename" /><br/>
							<c:if test="${bDTO.bFilename eq null }">
								[기존첨부 : 없음]
							</c:if>
							<c:if test="${bDTO.bFilename ne null }">
								[기존첨부 : ${bDTO.bFilename }]
							</c:if>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea name="bContent" rows="10" cols="60">${bDTO.bContent }</textarea>
						</td>
					</tr>
					<tr class="centered">
						<td colspan="2">
							<input type="text" name="page" value="${param.page }" />
							<input type="button" value="게시물수정하기" onclick="fn_update(this.form)" />
							<input type="reset" value="다시작성하기" />
							<input type="button" value="전체목록으로이동하기" onclick="fn_listPage(this.form)" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>