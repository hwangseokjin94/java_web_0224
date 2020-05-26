<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--1.Latte 빈 만들기 : 자바로는Latte cafeLatte = new Latte();  -->
	<jsp:useBean id="cafeLatte" class="bean.Latte"/>
	
	<!--2. cafeLatte 객체(빈)에 데이터 저장하기 : 자바로는 setter  -->
	<jsp:setProperty property="coffee" name="cafeLatte" value="인도네시아"/>
	<jsp:setProperty property="milk" name="cafeLatte" value="100"/>
	<jsp:setProperty property="water" name="cafeLatte" value="200"/>
	
	<!--3. cafeLatte 객체(빈)의 데이터 확인하기 : 자바로는 getter  -->
	<ul>
		<li>커피원산지 : <jsp:getProperty property="coffee" name="cafeLatte"/></li>
		<li>우유 : <jsp:getProperty property="milk" name="cafeLatte"/></li>
		<li>물 :<jsp:getProperty property="water" name="cafeLatte"/></li>
		
	</ul>


</body>
</html>