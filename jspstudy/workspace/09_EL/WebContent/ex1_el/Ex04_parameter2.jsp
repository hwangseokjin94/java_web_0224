<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 	
		/*
		1.request 에 담긴 parameter가 String 타입인경우 
			${param.파라미터}
		2. request에 담긴 parameter가 String[]타입인 경우
			${paramValues.파라미터[0]}
			${paramValues.파라미터[1]}
			${paramValues.파라미터[2]}
			*/
	%>

	
	작성자 : ${writer }<br/>
	작성자 : ${param.writer }<br/>
	취미 : ${paramValues.hobbies[0] }&nbsp;
		 ${paramValues.hobbies[1] }&nbsp;
		  ${paramValues.hobbies[2] }&nbsp;
		 ${paramValues.hobbies[3] }&nbsp;
		 ${paramValues.hobbies[4] } 
	 

</body>
</html>