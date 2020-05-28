<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
label{ /* 너비를 안먹으면 인라인 */
	width: 100px;
	display: inline-block;
}
</style>
</head>
<body>
	<form action="Q02_2.jsp">
		<label>제목</label><input type ="text" name = "title"/><br/> 
		<label>작성자</label><input type ="text" name = "writer"/><br/> 
		<label>내용</label><input type ="text" name = "content"/><br/>  
		<label>히트수</label><input type ="text" name = "hit"/><br/> 
	<input type="submit" value="작성하기"/>
	</form>
	
</body>
</html>