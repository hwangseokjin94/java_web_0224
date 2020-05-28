<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// String isSuccess = request.getParameter("isSuccess");
	// if ( isSuccess.equals("true") ) { }
	
	request.setCharacterEncoding("utf-8");
	boolean isSuccess = Boolean.parseBoolean(request.getParameter("isSuccess"));
	String message = "";
	String fileName =  "";
	if ( isSuccess ) {
		
	    fileName = (String)session.getAttribute("FILE_NAME");
	 
		BufferedReader br = null;
		try {
			String filePath = application.getRealPath("/" + fileName);
			br = new BufferedReader(new FileReader(filePath));
			String line = null;
			
			while (true) {
				line = br.readLine();  // 한 줄 읽기
				if (line == null) {
					break;
				}
			 message += line +"\n";
			}
		} catch (FileNotFoundException e) {
			out.println("해당 내용을 찾을 수 없다.");
		} catch (IOException e) {
			out.println("해당 내용을 읽을 수 없다.");
		} finally {
			try {
				if (br != null) { br.close(); }
			} catch (Exception e) { }
		}
	}  // if
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% if (isSuccess) { %>
		<h1>가입되었습니다.</h1>
		<h3>가입내용</h3>
		<pre><%=message %></pre>
		<br/>
		<form   method="POST" action= "Q02_5.jsp">
			<input type = "submit" value="탈퇴"/>
		</form>
	<% } else { %>
		<h1>가입되지 않았습니다.</h1>
		<a href="Q02_1.jsp">다시 가입하기</a>
	<% } %>
	
</body>
</html>










