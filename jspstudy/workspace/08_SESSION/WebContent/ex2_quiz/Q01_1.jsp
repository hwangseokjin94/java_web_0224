<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		if ( session.getAttribute("NAME") != null ) {
			session.removeAttribute("NAME");
		}
		if ( session.getAttribute("ENTERTAINER") != null ) {
			session.removeAttribute("ENTERTAINER");
		}
		if ( session.getAttribute("PLAYER") != null ) {
			session.removeAttribute("PLAYER");
		}
	%>

	<h3>설문조사를 시작합니다.</h3>
	<form action="Q01_2.jsp">
		작성자 <input type="text" name="name" /><br/><br/>
		<h4>1. 좋아하는 연예인은 누구인가요?</h4>
		<input type="text" name="entertainer" /><br/><br/>
		<input type="submit" value="제출" />
	</form>

</body>
</html>




