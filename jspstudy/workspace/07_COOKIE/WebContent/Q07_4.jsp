<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	request.setCharacterEncoding("utf-8");
 	
 	Cookie[] ckList = request.getCookies();
 	String savedID = null;
 	String savedPW = null;
 	String[] saved = {"savedID","savedPw"};
 	if(ckList != null && ckList.length>0){
 		for(Cookie ck : ckList){
 			for(int i = 0 ; i <ckList.length;i++){
 			if(ck.getName().equals(saved[i])){
 				savedID = ck.getValue();
 				savedPW = ck.getValue();
 				break;}
 			}
 		}
 	}
 
 %>   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<ul>
		<li>성명 : <%=savedID %></li>
		<%--  <li>아이디 <%= %></li> --%>
		<li>패스워드 <%= savedPW%></li>
		<%-- <li>주소<%= %></li>
		<li>전화번호<%= %></li>
		<li>이메일<%= %></li>
		<li>생년월일  : <%= %> 년 <%= %> 월<%= %> 일</li>
		<li>결혼:<%= %></li>  --%>
	</ul>
	

</body>
</html>