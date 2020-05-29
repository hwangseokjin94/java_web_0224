
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% 
String id = (String)request.getAttribute("ID"); 
%>
<script type="text/javascript">

onload = () => {
	
	if(confirm('탈퇴할까요?')){
	
		location.href='remove.jsp';
	}else{
		location.href='manager.jsp';
		
	}
}




</script>
<body>

</body>
</html>