<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	final String  DIRECTORY = request.getParameter("DIRECTORY"); //storage 폴더
	String fileName = request.getParameter("fileName");
	
	//1.다운로드 받을 파일의 실제 경로를 구하낟.
	String realPath = application.getRealPath("/"+DIRECTORY);
	//request.getServletContext().getRealPath(path);
	//request.getSession().getServletContext().getRealPath(path);
	
	//2.response 의 contentType을 다운로드를 하는 문서 타입으로 수정한다.
	response.setContentType("application/x-msdownload");
	response.setContentType("application/octet-stream");
	
	//3.File 클래스를 통해서 다운로드할 파일과 연결한다.
	File file  = new File(realPath + "/" +fileName );	
	//주의fileName 인코딩이 되어있지않으면 아래와 같이사용한다.
	//File file  = new File(realPath + "/" +URLEncoder.encode(fileName,"utf-8") );
	
	//4. response의  헤더 정보에 첨부파일의 이름을 저장한다.
	//여기에 저장된 이름으로 다운로드 파일의 이름이 결정된다.
	
	response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName,"utf-8").replace("\\+"," "));//파일에 직접인코딩해야됨	
	response.setHeader("Content-Length",  file.length()+"");//setHeader 는 문자열을 저장한다.
	
	
	//5. 실제로 다운로드를 진행한다.
	BufferedInputStream bis = null;
	BufferedOutputStream bos = null;
	
	try{
		//JSP에서 OutputStream을 사용할때 필요한 작업이다.
		//JSP와 Servlet의 출력 스트림의 겹침을 방지한다. (IllegalStateException 방지)
		out.clear();
		out = pageContext.pushBody();
		
		bis = new BufferedInputStream(new FileInputStream(file)); //다운로드할 파일을 읽어들이는 스트림.
		bos = new BufferedOutputStream(response.getOutputStream()); //download.jsp파일의 결과가 출력스트림의 내용이 된다.
		
		byte[] byteArray = new byte[(int)file.length()];
		bis.read(byteArray, 0, (int)file.length()); //서버에 저장된 파일file 전체를 byteArray
		
		bos.write(byteArray);
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(bos != null){bos.close();}
			if(bis != null){bis.close();}
		}catch(Exception e){
			e.printStackTrace();
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

</body>
</html>