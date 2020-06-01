<%@page import="dao.BlueDao"%>
<%@page import="dto.BlueDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//1.파라미터처리
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String email = request.getParameter("email");
	
	//2.DTO생성
	BlueDto bDto = new BlueDto();
	bDto.setId(id);
	bDto.setPw(pw);
	bDto.setName(name);
	bDto.setAge(Integer.parseInt(age));
	bDto.setEmail(email);
	
	//3.insert 처리
	int result = 0;
	BlueDao bDao = BlueDao.getInstance();
	result = bDao.insert(bDto);
	
	
	//4.insert처리 결과
	if( result > 0 ){
		out.println("<script>");
		out.println("alert('회원가입되었습니다.');");
		out.println("location.href='list.jsp'");
		out.println("</script>");	
	}else{
		out.println("<script>");
		out.println("alert('회원가입 되지 않았습니다. 다시시도하세요');");
		out.println("history.back()");
		out.println("</script>");			
	}
%>
