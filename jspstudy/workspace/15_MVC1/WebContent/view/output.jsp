<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	 요청한 현재날짜는 <%=request.getAttribute("RESULT") %>입니다.<br/>
	요청한 현재날짜는 ${RESULT }입니다	<br/>
	 
	
	요청한 현재시간은${TIME }입니다	<br/>
	<br/><br/>
	요청하신 ${DAN }단결과입니다.<br/><br/>
	${RESULTGU }
	

</body>
</html>