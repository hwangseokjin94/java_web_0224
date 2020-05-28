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
		
	String id =  (String)session.getAttribute("ID");			
	String pw = (String)session.getAttribute("PW");
	String name =(String)session.getAttribute("NAME");
	
	 fileName = id+".txt";
	 session.setAttribute("FILE_NAME", fileName);
	
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
	response.sendRedirect("Q02_4.jsp?isSuccess="+isSuccess);
		
		
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