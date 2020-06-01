<%@page import="db.DBConnect"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;
	
	try {
		conn = DBConnect.getConnection();
		sql = "SELECT * FROM GREEN WHERE ID = ? AND PW = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		rs = ps.executeQuery();
		if ( rs.next() ) {
			// 세션에 "LOGIN_CHK" 속성명으로 "OK" 값을 저장
			session.setAttribute("LOGIN_CHK", "OK");
			out.println("<h1>" + rs.getString("id") + "님 로그인 성공.</h1>");
			out.println("<a href='manager.jsp'>관리자 페이지로 이동</a>"); // 로그인에 성공한 모든 회원은 관리자로 가정
		}
	} catch (Exception e) { %>
		<script type="text/javascript">
			if ( confirm("아이디나 비밀번호가 잘못되었습니다.\n다시 입력할까요?"); ) {
				location.href = "loginPage.jsp"; // 로그인으로 이동
				// history.back();	이전 페이지
			} else {
				location.href = "joinPage.jsp";	// 회원가입으로 이동
			}
		</script> <%
	} finally {
		try {
			if (rs != null) { rs.close(); }
			if (ps != null) { ps.close(); }
			if (conn != null) { conn.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
%>

<style type="text/css">
	body {
		text-align: center;
	}
</style>