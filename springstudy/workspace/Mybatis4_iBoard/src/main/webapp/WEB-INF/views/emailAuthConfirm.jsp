<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fn_emailAuthConfirm(f) {
	//인증코드는 ${authKey}
	//t사용자입력갑 f.authKey.value
	var authKey ='${authKey}';
	if(authKey != f.authKey.value ){
		alert('틀립니다.');
		return;
	}else{
		alert('성공.서비스페이지로이동');
		location.href='imageBoardListPage';
	}
	
}
</script>
</head>

<body>
	
	<form>
	여기에 인증코드를 입력하세여
	<input type="text" name="authKey"/>
	<input type="button" value="인증하기" onclick="fn_emailAuthConfirm(this.form)">
	</form>
</body>
</html>