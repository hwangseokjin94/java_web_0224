<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%	request.setCharacterEncoding("utf-8"); %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_updatePwPage(f) {
		var email ='${param.email}';
		if(email ==f.email.value){
			f.action ="updatePwPage.jsp";
			f.submit();
		}else{
			alert('잘못된 이메일입니다.다시시도하세요');
			f.email.focus();
		}
	}
</script>
</head>
<body>
	<h1>가입당시 이메일을 입력하세요</h1>
	<form method="POST">
		이메일<input type="text" name ="email"/> <br/><br/><br/> 
		<input type= "hidden" name ="id" value="${param.id }"/>
		<input type="button" value="비밀번호 변경" onclick="fn_updatePwPage(this.form)"/>
		<input type="button" value="변경취소하기" onclick="history.back()"/>
		
	</form>
</body>
</html>