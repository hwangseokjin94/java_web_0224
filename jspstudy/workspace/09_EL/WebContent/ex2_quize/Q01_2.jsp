<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>




	<h3>request의 속성으로 넘어오는 LIST확인</h3>
	${ LIST[0] }<br/>
	${ LIST[1] }<br/>
	${ LIST[2] }<br/>
	<br/><br/><br/>
	${LIST }
	<br/><br/><br/><br/>
	
	${ LIST.get(0) }<br/>
	${ LIST.get(1) }<br/>
	${ LIST.get(2) }<br/>
	
	
	
</body>
</html>