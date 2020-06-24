<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--학생전송폼  -->
	<form action="v01" method="get">
		<lable>이름</lable>
		<input type="text" name="name" /><br/> 
		<lable>학과</lable>
		<input type="text" name="dept" /><br/> 
		<lable>학번</lable>
		<input type="text" name="stuNo" /><br/> 
		<input type="submit" value="전송"/>
	</form>
	
	<br/><br/><br/>
	
	<form action="v02" method="post">
		<lable>이름</lable>
		<input type="text" name="name" /><br/> 
		<lable>학과</lable>
		<input type="text" name="dept" /><br/> 
		<lable>학번</lable>
		<input type="text" name="stuNo" /><br/> 
		<input type="submit" value="전송"/>
	</form>

</body>
</html>