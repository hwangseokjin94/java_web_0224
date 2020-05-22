<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String contextPath = application.getContextPath();
	String filePath = application.getRealPath("잔향.txt");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- webcontent 는 가상공간임  매소드를 통해서  파일의 진짜위치를 알아야됨-->  
  	 <h3>컨텍스트 패스 : <%=contextPath %></h3>
  	 <h3>파일 패스 : <%=filePath %></h3>
  	  <h3> 파일내용 </h3>
  	 <%
  	BufferedReader br  = null;
  	 
  	 try{
  		 br = new BufferedReader(new FileReader(filePath));
  		 	while(true){
  		 		String line = br.readLine();
  		 		if(line == null){
  		 			break;
  		 		} 
  		 		out.println(line+"<br/>");
  		 	}
  	 }catch(FileNotFoundException e){
  		 out.println("파일이 존재하지않는다.");
  	 }catch(IOException e){
  		out.println("파일이 읽을수없다.");
  	 }finally{
  		 try{
  			 if(br !=null){br.close();}
  		 }catch(Exception e){
  			 	
  		 }
  	 }
  	 %>
  	 
  	 
  	 
</body>
</html>