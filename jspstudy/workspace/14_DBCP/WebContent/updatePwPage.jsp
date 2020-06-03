<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("utf-8");%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">/* this.form안되니따로 myForm이름 짓고해야됨. */
	function fn_pwConfirm() {
		var f = document.forms.myForm;
		if(f.pw.value =='' || f.pw.value != f.pw2.value){
			alert('비밀번호를 확인하세요');
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="wrap">
		<form name="myForm" action="updatePw.jsp"method="POST" onsubmit="return fn_pwConfirm()">
			신규비밀번호 <input type="password" name = "pw"/><br/><br/>
			비밀번호확인 <input type="password" name = "pw2"/><br/><br/>
			<input type="hidden" name="id" value="${param.id }"/>
			<input type="submit" value="비밀번호변경"/>
		</form>
	</div>
</body>
</html>