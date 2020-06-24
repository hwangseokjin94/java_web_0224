<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 
			<form action="member/login" method="get">
			은 아래와 연결된다.
			@RequestMapping(value = "member/login", method = RequestMethod.GET)
			
			주의.
			<form action="/member/login" method="get">는 동작하지 않는다.
			action 이나 location.href는 Mapping값이 슬래시 로 시작하면 안된다.
	 -->
	<form action="member/login" method="get"> 	
		<label>로그인</label>
		<input type="text" name="id" autofocus/><br/> 
		<label>비밀번호</label>
		<input type="password" name="pw" /><br/><br/>
		<input type="submit" value="로그인"/> 
	</form>	 
	
	<form action="member/login1" method="get"> 	
		<label>로그인</label>
		<input type="text" name="id" autofocus/><br/> 
		<label>비밀번호</label>
		<input type="password" name="pw" /><br/><br/>
		<input type="submit" value="로그인"/> 
	</form>	 
	
</body>
</html>