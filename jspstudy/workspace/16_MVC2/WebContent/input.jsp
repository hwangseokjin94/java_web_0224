<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_korean() {
		location.href = '/16_MVC2/korean.do';
	}
	function fn_english() {
		location.href = '/16_MVC2/english.do';
	}
	// *.do   모든요청은 하나의 컨트롤로러 처리를한다.
	// postfix값. do로 요청하는 모든 요청은 
	// URLMapping 값 '*do.' 로전달된다.
	
	
</script>
</head>
<body>
	<form>
		<input type ="button" value="한글인사"onclick="fn_korean()"/><br/><br/>
		<input type ="button" value="영문인사"onclick="fn_english()"/><br/><br/>
	</form>
</body>
</html>