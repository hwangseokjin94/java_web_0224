<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function fn_getImage() {
		location.href='/23_JSON/getImage.do';
		
	}
	onload = () => {
	
		
	}
	
</script>
</head>
<body>
	<form action="/23_JSON/login.do">
	 	아이디 <input type="text" name="id"/><br/><br/>
	 	비밀번호 <input type="password" name="id"/><br/><br/>
	 	자동로그인방지 
	 	<input type="button"value="이미지새로고침" onclick="fn_getImage()"><br/>
	 	<img src="${DIRECTORY }/${filename }" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="input_key" required/>
	 	
	 	<br/><br/>
	 	
	 	<input type="submit" value="로그인"/>
	</form>
</body>
</html>