<%@page import="java.io.FileWriter"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String agree = request.getParameter("agree");
	boolean isSuccess = false;
	String fileName = "";
	
	
	if(agree.equals("yes")){
		
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	
	 fileName = id+".txt";
	
	BufferedWriter bw =  null;
	
	 try{
		 String filePath = application.getRealPath("/"+fileName);
		 bw = new BufferedWriter(new FileWriter(filePath));
		 bw.write("가입아이디:"+id+"\n");
		 bw.write("가입 비밀번호:"+pw+"\n");
		 bw.write("가입성명:"+name+"\n");
		 isSuccess = true;
		 
	 }catch(IOException e){
		 e.printStackTrace();
	 }finally{
		 try{
			 if(bw != null){bw.close();}
		 }catch(Exception e){}
	 }
	
	}//if
	
	//이동
	response.sendRedirect("/02_JSP/ex3_quiz/Q05_4.jsp?isSuccess="+isSuccess+"&fileName="+fileName);
		
		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>