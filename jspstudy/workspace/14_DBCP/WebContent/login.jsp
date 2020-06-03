<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.WhiteDao"%>
<%@page import="dto.WhiteDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    request.setCharacterEncoding("utf-8");
	String id =request.getParameter("id");
	String pw = request.getParameter("pw");
	
	Cookie cookie = null;
	String saveIDChk = request.getParameter("saveIDChk");
	
	//1.아이디 기억하기를 체그했다면,
	if(saveIDChk != null){
		cookie = new Cookie("savedID",id);
		response.addCookie(cookie);
	}
	//2.아이디 기억하기를 체크하지 않았다면?
	else{
		//쿠키에저장된 savedID를 확인해서 존재하면 삭제한다.
		Cookie[] ckList = request.getCookies();
		if( ckList != null && ckList.length>0 ){
			for(Cookie ck : ckList){
				if(ck.getName().equals("savedID")){
					Cookie bisket = new Cookie("savedID","");
					bisket.setMaxAge(0);
					response.addCookie(bisket);
					break;
				}
			}
		}
	}		
	
	//1.DB로 보낼데이터
	//WhiteDto wDto = new WhiteDto();
	//wDto.setId(id);
	//wDto.setPw(pw);
	
	//2.DB로 보낼데이터
	Map<String,String> map = new HashMap<>();
	map.put("id", id);
	map.put("pw",pw);
	
	WhiteDao wDao = WhiteDao.getInstance();
	WhiteDto wDto = wDao.selectByIdPw(map);
	//rs가있으면?
	if(wDto != null){
		session.setAttribute( "USER",wDto ); //로그인된 회원의 정보를 USER라는 이름으로session에 올려둔다.
		out.println("<script>");
		out.println("alert('로그인되었습니다.')");		
		out.println("location.href='index.jsp'");
		out.println("</script>");
	}else{
		out.println("<script>");
		out.println("alert('아이디나 비밀번호가 잘못되었습니다.')");		
		out.println("history.back()");
		out.println("</script>");
		
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