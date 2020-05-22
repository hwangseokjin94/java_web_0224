<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!--현재페이지는 에러페이지 임을 알린다.  -->
<%@ page isErrorPage="true" %>    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrap">
		요청을 처리하는 과정에서 예기치 않은 에러가 발생했습니다.<br/>
		빠른시간내에 문제를 해결하겠습니다.<br/>
		<br/><br/>
		<ul>
			<li>에러 타입: <%=exception.getClass().getName() %></li>
			<li>에러 메세지:<%=exception.getMessage() %></li>
		</ul>
		<div>
			비상연락쳐 : 02-123-456<br/>
			긴급연락쳐 : 010-1111-1234<br/>
			
			<a href="mailto:xxx.@xxx.com">오류 신고하기</a>
		</div>
				
	</div>
</body>
</html>