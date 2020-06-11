<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_delete() {
		var f = document.forms.myForm;
		var pw = '${pw}'; //deletePageCommand가 넘겨준 pw
		if( pw != f.pw.value ){
			alert('비밀번호를 확인하세요');
			return false;
		}else{
			return true;
			//action 이 form에 잡혀있어서 true를 떄린당ㅎ
		}
	}

</script>
</head>
<body>
	<h1>비밀번호를 입력해주세요</h1>
	<form name="myForm" onsubmit="return fn_delete()" action="/24_GUESTBOOK/delete.guest" method="post">
	<input type="password" name ="pw"/><br/><br/>
	<input type="hidden" name ="no" value="${no }"/>
	<input type="submit" value="삭제"/>
	<input type="button" value="목록으로이동하기" onclick="location.href='/24_GUESTBOOK/insert.guest'"/>
	<input type="button" value="방명록이동하기" onclick="location.href='/24_GUESTBOOK/viewPage.guest?no=${no }'"/>
	
	</form>
	
</body>
</html>