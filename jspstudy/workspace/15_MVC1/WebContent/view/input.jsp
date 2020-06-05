<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_date() {
		location.href='/15_MVC1/DateController';
		
	}
	function fn_time() {
		location.href ='/15_MVC1/TimeController';
		
	}
</script>
</head>
<body>
	
	<!-- VIEW 가급적 로직은 작성하지 않고 화면만 구성한다. -->
	<!--  VIEW는 CONTROLLER에게요청한다 -->	
	<form>
		<input type="button" value="현재날짜를 요청합니다." onclick="fn_date()"/></br/>
		<input type="button" value="현재시간을 요청합니다." onclick="fn_time()"/>
	</form>
	<br/><br/>
	<form action="/15_MVC1/GugudanController">
		단<input type="text" name="dan" size="5"/><br/>
		<input type="submit"value="구구단 결과확인"/> 
	</form>
	
</body>
</html>