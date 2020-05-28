<%@page import="java.sql.Date"%>
<%@page import="bean.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    request.setCharacterEncoding("utf-8");   
    
	Board board= new Board();
	
	board.setTitle(request.getParameter("title"));
	board.setWriter(request.getParameter("writer"));
	board.setContent(request.getParameter("content"));	
	board.setHit(Integer.parseInt(request.getParameter("hit")) );
	board.setPostDate(new Date(System.currentTimeMillis() ) );
		
	pageContext.setAttribute("BOARD", board);
	
    %>
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   제목 : ${BOARD.title}<br>
   작성 : ${BOARD.writer}<br>
   내용 : ${BOARD.content}<br>
   조회 : ${BOARD.hit}<br>
   게시 : ${BOARD.postDate}<br>
  
   제목 : ${BOARD.getTitle()}<br>
   작성 : ${BOARD.getWriter()}<br>
   내용 : ${BOARD.getContent()}<br>
   조회 : ${BOARD.getHit()}<br>
   게시 : ${BOARD.getPostDate()}<br>
  
   
</body>
</html>







