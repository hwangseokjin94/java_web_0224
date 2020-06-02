<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pw = request.getParameter("pw");
	

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_updatePage(f) {
		var pw = '<%=pw%>'; 
		//var pw = '${param.pw}';
		f.pw.value
		if(pw == f.pw.value){
			alert('회원 정보 수정 페이지로 이동합니다.');
			f.action = 'updatePage.jsp';
			f.submit();
		}else{
			alert('비밀번호를 확인하세요');
			f.pw.focus();		
		}		
	}
</script>
</head>
<body>
	<h1>회원정보 수정을 위해 비밀번호를 입력하세요</h1>
	<form method="POST">
		비밀번호 확인 <input type="password" name="pw" /><br/><br/>
		<input type="hidden" name = "id" value="${param.id }"/>
		<input type="hidden" name = "name" value="${param.name }"/>
		<input type="hidden" name = "age" value="${param.age }"/>
		<input type="hidden" name = "email" value="${param.email }"/>
		<input type="button" value="회원정보수정" onclick="fn_updatePage(this.form)"/>
		<input type="button" value="돌아가기" onclick="history.back()"/>
		
	</form>
</body>
</html>







