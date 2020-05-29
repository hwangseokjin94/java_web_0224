<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>향상된 for문으로 사용</h3>
		<%
			String[] hobbies = {"운동","독서","영화","여행","낚시"};
		
		/*일반자바변수는 el에서 사용할수없다..  */
		pageContext.setAttribute("HOBBIES", hobbies);
		%>
		
		<!--1.인덱스를 안쓰는 방법  -->
		<h3>취미목록</h3>
		<ul>
			<c:forEach var = "hobby" items = "${HOBBIES }">
				<li>${hobby }</li>
			</c:forEach>
		</ul>c
		
		
		<!--2.인덱스를 쓰는 방법   인덱스를 사용하는 변수는 varStatus-->
		<h3>취미목록</h3>
		<ul>
			<c:forEach varStatus="h"  items = "${HOBBIES }">
				<li>${h.index },${h.count }</li>
			</c:forEach>
		</ul>
		
</body>
</html>