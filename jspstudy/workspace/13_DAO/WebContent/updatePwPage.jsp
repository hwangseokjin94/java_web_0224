<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <% request.setCharacterEncoding("utf-8");
 request.getParameter("id");
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_updatePw(f) {
		if(f.pw.value == '' || f.pw.value != f.pw2.value){
			alert('비밀번호를 확인하세요.');
			return;
		}
		f.action ='updatePw.jsp';
		f.submit();
	}
</script>
</head>
<body>
		<form method="POST">
			신규비밀번호 <input type="password" name="pw"/><br/>
			비밀번호 확인 <input type ="password" name="pw2"/><br/><br/>
			<input type="hidden" value="${param.id }" name="id" />
			<input type="button" value="비밀번호변경하기" onclick="fn_updatePw(this.form)">
			<input type="button" value="변경취소하기" onclick="history.go(-2)"/>
		</form>
		
</body>
</html>