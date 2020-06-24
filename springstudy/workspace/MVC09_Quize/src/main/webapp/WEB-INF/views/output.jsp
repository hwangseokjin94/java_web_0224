<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${signal2}">
<input type="hidden" name="a" value="${a}"/>
<input type="hidden" name="b" value="${b}"/>
<h1>${message}</h1>
첫번쨰수: ${a} <br/><br/>
두번쨰수: ${b} <br/><br/>
 ${a} ${op}  ${b} =  ${result}<br><br>
<input type="submit" value="${signal}"> GOGO!!
</form>





</body>
</html>