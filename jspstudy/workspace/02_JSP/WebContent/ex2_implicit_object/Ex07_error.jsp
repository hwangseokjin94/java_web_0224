<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	/*try-catch를 통한 예외 처리  */
	try{
		//예외발생코드
		int a= Integer.parseInt("홍길동");
		String param = null;
		param.charAt(0);
	}catch(Exception e){
		// 예외처리하는 영역
		//예외 페이지를 직접만즐기가 불편하다.
		out.println("예기치 않은 문제가 발생했다.");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


</body>
</html>