<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.wrap{
		width: 550px;
		margin: auto;
	}
	label {
		display: inline-block;
		width: 150px;		
	}
	input[type=text],input[type=password]{
		padding: 3px 10px;
		margin-bottom:5px;
		width: 350px;
	}
	a{
		text-decoration: none;
		color: black;
	}
</style>
</head>
<body>
	
	<%
		//쿠키에 savedID 값이 있으면 화면에 표시한다.
		Cookie[] ckList = request.getCookies();
		String id = null;
		if(ckList != null && ckList.length>0 ){
			for(Cookie ck : ckList){
				if(ck.getName().equals("savedID")){
					id = ck.getValue();
					break;
				}
			}
		}
	%>
	
	
	
	<div class="wrap">
		<form action="login.jsp" method="POST">
			<%if(id == null){ %>					
				<label>아이디</label>
				<input type="text" name="id" autofocus/><br/>
				<label>비밀번호</label>
				<input type="password" name="pw"/><br/><br/>
				<input type="checkbox" name="saveIDChk" id="lbl-save" />
				<label for ="lbl-save">아이디 기억하기</label>&nbsp;&nbsp;				
			<%}else{ %>
				<label>아이디</label>
				<input type="text" name="id" value="<%=id%>"/><br/>
				<label>비밀번호</label>
				<input type="password" name="pw"/><br/><br/>
				<input type="checkbox" name="saveIDChk" id="lbl-save" checked/>
				<label for ="lbl-save">아이디 기억하기</label>&nbsp;&nbsp;
			<%} %>
			
			
			<a href="findIDPage.jsp">아이디 찾기</a>&nbsp;&nbsp;
			<a href="findPwPage.jsp">비밀번호 찾기</a><br/><br/>
			<input type="submit" value="로그인"/>
		</form>
	</div>
</body>
</html>