<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	번호 :${BDTO.no }<br/>
	제목 :${BDTO.title }<br/>
	내용 :<br/>
	<pre>${BDTO.content }</pre><br/>
	작성일 :${BDTO.postdate }<br/>
	
	<br/>
	<input type="button" value="목록으로이동" onclick="location.href='/20_MYBATIS/listPage.do'"/>
	<input type="button" value="삭제" onclick="location.href='/20_MYBATIS/delete.do?no=${BDTO.no}'"/>
	<input type="button" value="수정하기" onclick="location.href='/20_MYBATIS/updatePage.do?no=${BDTO.no}'"/>
	
</body>
</html>