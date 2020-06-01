<%@page import="db.DBConnect"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;
	
	try {
		conn = DBConnect.getConnection();
		sql = "SELECT * FROM GREEN WHERE ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		if (rs.next()) { %> <!-- 가입하려는 id로 검색된 회원이 있으면 사용 중인 아이디라는 의미가 된다. -->
			<script type="text/javascript">
				alert("존재하는 아이디입니다. 다른 아이디를 사용하세요.");
				history.back();
			</script> <%
		} else { %>
			<script type="text/javascript">
				var useId = "<%=id %>";
				alert("사용 가능한 아이디입니다.");
				location.href = "joinPage.jsp?useId=" + useId;
			</script> <%
		}
	} catch (Exception e) {
		e.printStackTrace();
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