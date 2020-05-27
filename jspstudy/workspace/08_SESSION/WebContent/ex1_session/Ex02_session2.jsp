<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- User user = new User(); -->
<jsp:useBean id="user" class="bean.User"/>


<!-- user.setId(request.getParameter("id"));
user.setId(request.getParameter("pw")); -->
<jsp:setProperty property="*" name="user"/>
    
<%
	Map<String,String > map = new HashMap<>(); //Db역활 ID PW저장
	map.put("user1", "1111");
	map.put("user2", "1111");
	map.put("user3", "1111");
	map.put("user4", "1111");
	map.put("user5", "1111");
	
	if( map.containsKey(user.getId()) ){ //아이디가 존재하는가 검사
		//map.get("user")=="1111"
		if( map.get(user.getId()).equals(user.getPw()) ){//저장된 비밀번호와 입력한 비밀번호가 일치하는지 검사
			session.setAttribute("LOGIN_USER", user); //세션에 로그인 사용자 정보 (id,pw)저장
		} 
	}
	
	response.sendRedirect("Ex02_session1.jsp");
	
%>
