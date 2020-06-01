<%@page import="db.DBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	
	Connection conn = null;
	PreparedStatement ps = null;
	String sql = null;
	int result = 0;
	
	try {
		conn = DBConnect.getConnection();
		sql = "DELETE FROM GREEN WHERE ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		result = ps.executeUpdate();
		
		if ( result > 0 ) { %>
			<script type="text/javascript">
				alert("정상적으로 탈퇴되었습니다.");
				location.href = "manager.jsp";
			</script> <%
		}
	} catch (Exception e) { %>
		<script type="text/javascript">
			alert("회원 탈퇴에 실패했습니다. 관리자 페이지로 이동합니다.");
			location.href = "manager.jsp";
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