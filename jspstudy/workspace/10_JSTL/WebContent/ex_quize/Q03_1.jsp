<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>일반 forEach연습</h3>
<form action="Q03_2.jsp">
최소크기 : <input type="text" name = "start" min="1" max="7"/><br/>
최대크기 : <input type="text" name = "end" min="1" max="7"/><br/>

<h3>향상 forEach연습</h3>
<input type="checkbox" name="food" value="불고기">불고기 <br/>
<input type="checkbox" name="food" value="닭갈비">닭갈비 <br/>
<input type="checkbox" name="food" value="순대국">순대국 <br/>
<input type="checkbox" name="food" value="자장면">자장면 <br/>
<input type="checkbox" name="food" value="해장국">해장국 <br/>


<input type="submit" value="전송"/>
<input type="reset" value="취소"/>


</form>
</body>
</html>