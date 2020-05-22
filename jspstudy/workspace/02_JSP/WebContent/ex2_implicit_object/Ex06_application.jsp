<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.cntered{
		text-align: center;
	}
	table{
		width: 800px;
		margin: auto;
				
	}
	table, td{
		padding: 5px 10px; /* 상하 5 좌우 10 */
		border : 1px solid black;
		border-collapse: collapse;
	}
	tr:nth-of-type(1){
		background: lightgray;
		
	}
	tr :nth-of-type(4) >td{
		text-align: center;
	}
	input[type=text], textarea{
		width: 600px;
	}
</style>
</head>
<body>
	<h1 class="cntered">나만의 일기장</h1>
	<form  method="POST" action="<%=application.getContextPath()%>/ex2_implicit_object/Ex06_diary.jsp">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" /></td>
				
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" /></td>				
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea  name ="content"rows="10" cols="50"></textarea>></td>								
			</tr>
			<tr>
				<td  class="cntered" colspan="2">
					<input type="submit" value="일기 저장하기"/>
					<input type="reset" value="다시작성"/>
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>