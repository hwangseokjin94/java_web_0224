<%@page import="db.DBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id =(String)session.getAttribute("ID");
	
	Connection conn = null;
	PreparedStatement ps = null;
	String sql = null;
	int result = 0;
	
	try{
		conn = DBConnect.getConnection();
		sql ="DELETE FROM GREEN WHERE ID = ? ";
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		result = ps.executeUpdate();
		if (result >0){ %>
			<script type ="text/javascript">
				alert("탈퇴성공.");
				location.href='manager.jsp';
			</script><%}
	}catch (Exception e) {
		response.sendRedirect("manager.jsp");	
	} finally {
			try {
				if ( ps != null ) { ps.close(); }
				if ( conn != null ) { conn.close(); }
			} catch (Exception e) { }
		}
		
	
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">




</script>
</body>
</html>