<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.net.URLDecoder"%>
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
		Cookie[] ckList = request.getCookies();
	%>
	<%!
		//선언부 (메소드 정의)
		public String getCookieValue(Cookie[] ckList ,String cookieName) {
		  try{
		
			if(ckList != null && ckList.length > 0 ){
				for(Cookie ck : ckList){
					if(ck.getName().equals(cookieName)){
						return URLDecoder.decode(ck.getValue(),"utf-8");
					}
				}
			}//if
			}catch(UnsupportedEncodingException e){
				return null;
			}
		  return null;
		
	}
	
	%>
	
	
	
	
	
	
	<ul>
		 <li>아이디 <%=getCookieValue(ckList, "ID") %></li> 
		<li>패스워드 <%=getCookieValue(ckList, "PW") %></li>
		<li>성명 : <%=getCookieValue(ckList, "NAME") %></li>
		 <li>주소<%=getCookieValue(ckList, "ADDRESS") %></li>
		<li>전화번호<%=getCookieValue(ckList, "PHONE") %></li>
		<li>이메일<%=getCookieValue(ckList, "EMAIL") %></li>
		<li>생년월일<%=getCookieValue(ckList, "BIRTHDAY") %></li>
		<li>결혼:<%=getCookieValue(ckList, "MARRIAGE") %></li>  
		<li>직업:<%=getCookieValue(ckList, "JOB") %></li>  
	</ul>


</body>
</html>