<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_insert() {
		location.href="/20_MYBATIS/insertPage.do"
	}
	function fn_list() {
		location.href="/20_MYBATIS/listPage.do"
	}
</script>
</head>
<body>
	<from>
		<input type="button" value="삽입" onclick="fn_insert()"/><br/><br/>
		<input type="button" value="목록" onclick="fn_list()"/><br/><br/>
		
	</from>
</body>
</html>