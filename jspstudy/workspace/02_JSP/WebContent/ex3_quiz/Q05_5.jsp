<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   	request.setCharacterEncoding("utf-8");
   
   String fileName =request.getParameter("fileName");
   String filePath = application.getRealPath("/"+fileName);
   
   String isDelete ="false";
   File file = new File(filePath);
   if(file.exists() ){
	    file.delete();
	    isDelete= "true";
   }
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var isDelete = '<%=isDelete%>';
	if (isDelete == 'true'){
		alert('탈퇴되었습니다.');
		location.href = '/02_JSP/ex3_quiz/Q05_1.jsp';
		
	}else{
		alert('탈퇴되지 않았습니다');
		history.back();
	}	
</script>
</head>
<body>

</body>
</html>