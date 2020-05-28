<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!--파라미터라면  -->
	이름 :${param.name }<br/>
	나이 :${param.age }<br/>
	전화번호: ${param.phone }<br/>
<!--  속성이라면-->
	이름 :${name }<br/>
	나이 :${age }<br/>
	전화번호: ${phone }<br/>
</body>
</html>