<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	label {
		width: 200px;
		display: inline-block;
	}
</style>
<script type="text/javascript">
	function fn_send1(f) {
		f.action = '/05_BEAN/Person2.jsp';
		f.submit();
		
	}
	function fn_send2(f) {
		f.action = '/05_BEAN/Person3.jsp';
		f.submit();
		
	}
</script>
</head>
<body>

	<form method="post">
		<label for="pName">이름</label>
		<input type="text" name="name" id="pName" /><br/>
		<label for="pAge">나이</label>
		<input type="text" name="age" id="pAge" /><br/>
		<label for="pHeight">키</label>
		<input type="text" name="height" id="pHeight" /><br/>
		<label><input type="radio" name="gender" value="남" />남</label>
		<label><input type="radio" name="gender" value="여" />여</label><br/>
		<input type="button" value="전송하기1" onclick="fn_send1(this.form)"/>
		<input type="button" value="전송하기2" onclick="fn_send2(this.form)"/>
	</form>

</body>
</html>