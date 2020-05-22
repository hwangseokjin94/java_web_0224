<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- page 지시어의 errorPage 속성을 이용해서 예외처리  -->
   
   <%@ page errorPage="Ex08_errorPage.jsp" %>
   <%
   /*try-catch 문잉 없어도 예외가발생하면 Ex08_errorPage.jsp이동한다.  */
   String content =request.getParameter("content");
   content.charAt(0);
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>