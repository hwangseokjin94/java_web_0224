<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<ul>
	<li>성명 :${obj.name.substring(0,1)}</li>
	<li>나이:${obj.age}</li>
	<li>결혼여부:${obj.isMarried}</li>
</ul>
</body>
</html>