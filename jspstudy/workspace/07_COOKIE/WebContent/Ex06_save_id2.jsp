<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String userID = request.getParameter("userID");
	String saveIDChk = request.getParameter("saveIDChk");
	Cookie cookie = null;
	
	//1. 아이디 기억하기(saveIDChk)를 체크했다면 , 
	
	if(saveIDChk != null){
		cookie = new Cookie("savedID",userID);//쿠키이름 savedID , 사용자의 아이디가 쿠키값으로 저장된다.
		cookie.setMaxAge(60*60*24); //savedID 쿠키는 1일간 유효하다.
		response.addCookie(cookie); // savedID쿠키를 사용자의 웹 브라우저 (쿠키 저장소)에 저장한다.
	}
	
	//2. 아이디 기억하기(saveIDChk)를 체크하지 않았다면
	//기존에 생성된 savedID ,쿠키 여부를 확인해서 삭제
	else{
		Cookie[] ckList = request.getCookies();
		if(ckList != null && ckList.length > 0){
			for(Cookie ck  : ckList){
				if(ck.getName().equals("savedID"));
				 cookie = new Cookie("savedID","");
				 cookie.setMaxAge(0);
				 response.addCookie(cookie);
				 break;
						
			}
		}
	}
	
	//3. 로그인 화면으로 되ㅇ돌아가기 
	response.sendRedirect("/07_COOKIE/Ex06_save_id1.jsp");
%>
