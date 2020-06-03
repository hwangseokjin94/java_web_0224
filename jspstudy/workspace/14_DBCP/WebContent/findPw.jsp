<%@page import="dto.WhiteDto"%>
<%@page import="dao.WhiteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%
	request.setCharacterEncoding("utf-8");
	String id=  request.getParameter("id");
	
	WhiteDao wDao = WhiteDao.getInstance();
	boolean isMember = wDao.isMember(id);
	
	pageContext.setAttribute("ISMEMBER",isMember);


%>

<c:if test="${ISMEMBER eq true}">
	<script type="text/javascript">
		alert('비밀번호를 새로 설정하겠습니다.');
		location.href ='updatePwPage.jsp?id=<%=id%>';		
	</script>
</c:if>    

<c:if test="${ISMEMBER ne true}">
	<script type="text/javascript">
		alert('회원정보가 없습니다. 다시시도하세요');
		history.back();		
	</script>
</c:if>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>