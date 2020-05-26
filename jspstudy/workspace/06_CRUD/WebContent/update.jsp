<%@page import="db.DBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="red" class="bean.Red"/>
	
	<<jsp:setProperty property="*" name="red"/>

<!-- 
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String address = request.getParameter("address"); -->
	<%
	Connection conn = null;
	PreparedStatement ps = null;
	String sql = null;
	int result = 0;
	
	try {
		conn = DBConnect.getConnection();
		sql = "UPDATE RED SET PW = ?, NAME = ?, AGE = ?, ADDRESS = ? WHERE ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, red.getPw());
		ps.setString(2, red.getName());
		ps.setInt(3, red.getAge());
		ps.setString(4,red.getAddress());
		ps.setString(5, red.getId());
		
		result = ps.executeUpdate();
		if ( result > 0 ) {
			out.println("<script>");
			out.println("alert('회원 정보가 수정되었습니다.');");
			out.println("location.href='/06_CRUD/list.jsp'");
			out.println("</script>");
		}
	} catch (Exception e) {
		out.println("<script>");
		out.println("alert('회원 정보가 수정되지 않았습니다.');");
		out.println("history.back()");
		out.println("</script>");
	} finally {
		try {
			if ( ps != null ) { ps.close(); }
			if ( conn != null ) { conn.close(); }
		} catch (Exception e) { }
	}
	
%>
