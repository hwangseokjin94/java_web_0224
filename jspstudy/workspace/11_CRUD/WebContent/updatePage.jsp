<%@page import="db.DBConnect"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style type="text/css">
	table {
		width: 400px;
		height: 150px;
		margin: auto;
		border-collapse: collapse;
	}
	th, td {
		border: 1px solid black;
		padding: 10px;
	}
</style>
<script type="text/javascript">
	function update( f ) {
		f.action = "update.jsp";
		f.submit();
	}
	function selectAddr() {
		
	}
</script>
</head>
<body onload="selectAddr()">

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

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
		if ( rs.next() ) { %>
			<form method="post">
				<table>
					<thead>
						<tr>
							<th colspan="2">개인정보 수정</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>아이디</td>
							<td><%=id%><input type="hidden" name="id" value="<%=id %>" /></td>
						</tr>
						<tr>
							<td>성명</td>
							<td><input type="text" name="name" value="<%= rs.getString("name") %>" /></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><input type="text" name="addr" value="<%= rs.getString("addr") %>" /></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="2" style="text-align: center">
								<input type="button" value="돌아가기" onclick="location.href='manager.jsp'" /> 
								<input type="button" value="수정" onclick="update(this.form)" /> 
								<input type="reset" value="취소" />
							</td>
						</tr>
					</tfoot>
				</table>
			</form>
	<% } // end if
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

</body>
</html>