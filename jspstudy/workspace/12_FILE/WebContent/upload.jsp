<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// request 의 인코딩은 불필요하다.
	// MultipartRequest 클래스를 생성할 때 인코딩이 필요하다.
	
	
	// 1. 저장될 폴더 storage 를 상수로 처리한다.
	final String DIRECTORY = "storage";

	// 2. storage 폴더의 실제 경로를 알아낸다.
	String realPath = application.getRealPath("/" + DIRECTORY);
	
	// 3. MultipartRequest 객체를 생성한다.
	// 객체를 생성하면 업로드가 진행된다.
	
	MultipartRequest mr = new MultipartRequest(
			request,
			realPath,
			1024 * 1024 * 10,  // 업로드 가능한 파일의 크기, 바이트 (현재 10MB)
			"utf-8",
			new DefaultFileRenamePolicy()  // 동일한 이름의 파일이 업로드되면 원래 파일명 뒤에 숫자를 추가하여 이름 중복을 해결하겠다.
			);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

 a{
 	text-decoration: none ; /*밑줄없음 */
 }
</style>
</head>
<body>
	<h3>업로드 결과</h3>
	<ul>
		<li>저장 경로 : <%= realPath %></li>
		<li>업로더 : <%=mr.getParameter("uploader") %></li>
		<li>올릴때 파일명 <%= mr.getOriginalFileName("fileName") %></li>
		<li>저장된 파일명 : <%=mr.getFilesystemName("fileName") %></li>
		
	
		<% 
			//mr에저장된 파일 자체를 져오려면getFile()메소드를 사용한다. 
			File file = mr.getFile("fileName");
			String fileName = file.getName();//파일명
			long fileSize = file.length() / 1024; //기본단위는 바이트 , 1024로 나누면 킬로바이트(KB) 
			String lastModifiedDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified());		
		%>
		<li>파일명  : <%=fileName %></li>
		<li>파일크기<%=fileSize %></li>
		<li>수정날짜<%=lastModifiedDate %></li>
		<li><a href = "download.jsp?DIRECTORY=<%=DIRECTORY %>&fileName=<%=fileName%>">다운로드</a></li>
	</ul>
</body>
</html>