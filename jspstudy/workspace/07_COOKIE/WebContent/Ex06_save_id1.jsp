<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		//savedID쿠키 여부 확인
		Cookie[] ckList =request.getCookies();
		String savedID = null;	
	
		if(ckList != null && ckList.length>0){
			for(Cookie ck : ckList){
				if(ck.getName().equals("savedID")){
					savedID = ck.getValue();
					break;
				}
			}
		}
	%>


<form action = "/07_COOKIE/Ex06_save_id2.jsp">
	<%if (savedID == null){ %>
		아이디 <input type="text" name = "userID"/> <br/><br/>
		아이디 기억하기 <input type="checkbox" name  ="saveIDChk"/><br/><br/>
		<%}else{ %>
		아이디 <input type="text" name = "userID" value ="<%=savedID%>"/> <br/><br/>
		아이디 기억중<input type="checkbox" name  ="saveIDChk" checked/><br/><br/>
		<% } %>
	<input type="submit" value="로그인"/>
</form>
</body>
</html>