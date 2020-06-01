<%@page import="db.DBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
	
	Connection conn = null;
	PreparedStatement ps = null;
	String sql = null;
	int result = 0;
	
	try {
		conn = DBConnect.getConnection();
		sql = "INSERT INTO GREEN VALUES (GREEN_SEQ.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);
		if ( age.isEmpty() ) {
			ps.setInt(4, 0);
		} else {
			ps.setInt(4, Integer.parseInt(age));
		}
		if ( addr.isEmpty() ) {
			ps.setString(5, addr);
		}
		result = ps.executeUpdate();
		if ( result > 0 ) { %>
			<script type="text/javascript">
				alert("가입되었습니다. 로그인하세요.");
				location.href = "loginPage.jsp";
			</script> <%
		}
	} catch (Exception e) { %>		
		<script>
			alert("실패했습니다. 다시 시도하세요.");
			location.href = "joinPage.jsp";
		</script> <% 
	} finally {
		try {
			if (ps != null) { ps.close(); }
			if (conn != null) { conn.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
%>