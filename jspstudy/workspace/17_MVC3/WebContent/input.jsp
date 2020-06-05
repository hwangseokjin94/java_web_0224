<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_morning() {
		location.href = '/17_MVC3/morning.do';
	}
	function fn_lunch() {
		location.href = '/17_MVC3/lunch.do';
	}
	function fn_evening() {
		location.href = '/17_MVC3/evening.do';
	}
</script>
</head>
<body>
	<form action="">
		<input type="button" value="오늘의 아침메뉴" onclick="fn_morning()"/><br/><br/>
		<input type="button" value="오늘의 점심메뉴" onclick="fn_lunch()"/><br/><br/>
		<input type="button" value="오늘의 저녁메뉴" onclick="fn_evening()"/><br/><br/>
		
		
	</form>
</body>
</html>