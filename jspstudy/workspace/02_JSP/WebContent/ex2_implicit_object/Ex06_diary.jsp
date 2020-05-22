<%@page import="java.io.IOException"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.io.BufferedWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
	String title =request.getParameter("title");
	String writer =request.getParameter("writer");
	String content =request.getParameter("content");
	
	/* 한컴퓨터안에 동일한이름을 저장할수없어서 밀리세컨으로 파일명과 같이저장후
	다운할떄는 밀리세컨 지우는 로직을 짜주는것이 좋다...*/
	
	//파일명 : 2020-5-22_작성자.txt
	
	// 파일명 : 2020-5-22_작성자.txt
	Calendar calendar = Calendar.getInstance();
	int year = calendar.get(Calendar.YEAR);
	int month = calendar.get(Calendar.MONTH) + 1;
	int day = calendar.get(Calendar.DATE);
	
	String fileName = year + "-" + month + "-" + day + "_" + writer + ".txt";
	BufferedWriter bw = null;
	boolean isSuccess = false;
	
	try{
		String filePath = application.getRealPath("/"+fileName);
		bw  = new BufferedWriter(new FileWriter(filePath));
		bw.write("날짜 : "+year+"년"+month+"월"+"일\n");
		bw.write("작성자 :"+writer+"\n");
		bw.write("제목 : "+title+"\n");
		bw.write("내용\n"+content);
		isSuccess =true;
		
	}catch(IOException e){
		
	}finally{
		try{
			if(bw != null) {bw.close();}
		}catch(Exception e){}
	}
	


%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var isSuccess = '<%=isSuccess%>';
	if(isSuccess == 'true'){
		alert('일기가 저장되었다.');
	}else {
		alert('일기가 저장되지않았다.');
		}
	//이전페이지로 이동
	history.back(); //history.go(-1);
</script>
</head>
<body>

</body>
</html>