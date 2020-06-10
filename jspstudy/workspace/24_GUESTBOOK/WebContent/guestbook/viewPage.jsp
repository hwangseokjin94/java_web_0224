<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel= "stylesheet" type="text/css" href="co.css">
<style type="text/css">
h1{

color: red;
}
</style>
<script type="text/javascript">
	function fn_update() {
		var input = prompt("비밀번호를 입력하세요");
		var pw = '${gDTO.pw}';
		if(input ==pw){
			if(confirm('방명록을 수정할까요?')){
				return true;//submit 허용
			}else{
				alert('취소되었습니다.');
				return false;
			}
		}else{
			alert('잘못된 비밀번호입니다.');
			return false;
		}
	}

</script>
</head>
<body>
<div class="wrap">
		<h1>${gDTO.writer }님의 방명록입니다.방명록 보기</h1>
		<form onsubmit="return fn_update()" action="/24_GUESTBOOK/update.guest" method="POST">			
			<table>
				<tbody>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" value="${gDTO.title }"/></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer" value="${gDTO.writer}" readonly/></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="email" value="${gDTO.email}"/></td>
					</tr>
					
					<tr>
						<td>파일</td>
						<td>
						<c:if test="${gDTO.filename eq null}">
							없음
						</c:if>
						<c:if test="${gDTO.filename ne null}">
							<a href="">${gDTO.filename }</a>
						</c:if>
							
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea  name="content" rows="10" cols="60">${gDTO.content}</textarea>
						</td>					
					</tr>
					<tr>
						<td colspan="2">
							<input type="hidden" name="no" value="${gDTO.no }"/>
							
							<input type="submit" value="변경사항수정하기"/>
							<input type="reset" value="다시작성하기"/>
							<input type="button" value="목록으로 이동하기" onclick="location.href='/24_GUESTBOOK/listPage.guest'"/>
						</td>
					</tr>
				</tbody>
			</table>
		</form>	
	</div>
</body>
</html>