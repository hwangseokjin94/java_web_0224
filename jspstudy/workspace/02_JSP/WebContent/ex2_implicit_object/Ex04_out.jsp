<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--1. 1~10 사이의 홀수를 모두 출력하기 -->
	
	<%
	for(int i = 1 ; i <11 ; i++ ){
		if(i%2 == 1){%>
			<%=i%>
	<%}} %>	
			
	
		<br/>
	
	<!--2. out 1~10 사이의 홀수를 모두 출력하기 -->
	
	<%
	for(int i = 1 ; i <11 ; i++ ){
		if(i%2 == 1){
			out.println(i);
		}
	} %>	
			
	
	
</body>
</html>