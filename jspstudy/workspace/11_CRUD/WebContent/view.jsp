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
<title>회원 상세 보기</title>
<style type="text/css">
	table {
		width: 800px;
		height: 200px;
		margin: auto;
		border-collapse: collapse;
	}
	td {
		width: 100px;
		border: 1px solid black;
		text-align: center;
		padding: 10px;
	}
</style>
<script type="text/javascript">
	function pwCheckPage(f) {
		f.action = "pwCheckPage.jsp";
		f.submit();
	}
</script>
</head>
<body>
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
			if ( rs.next() ) {
				String pw = rs.getString("pw"); %>
				<table>
					<thead>
						<tr>
							<td colspan="6">회원 정보</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>회원번호</td>
							<td>아이디</td>
							<td>이름</td>
							<td>성별</td>
							<td>주소</td>
							<td>가입일</td>
						</tr>
						<tr>
							<td><%=rs.getInt("idx") %></td>
							<td><%=rs.getString("id") %></td>
							<td><%=rs.getString("name") %></td>
							<td><%=rs.getInt("age") %></td>
							<td><%=rs.getString("addr") %></td>
							<td><%=rs.getDate("reg_date") %></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td colspan="7">
								<form method="post">
									<input type="button" value="리스트로 이동" onclick="location.href='manager.jsp'" /> 
									<input type="button" value="수정하기" onclick="pwCheckPage(this.form)" />
									<input type="hidden" name="id" value="<%=id %>" />
									<input type="hidden" name="pw" value="<%=pw %>" />
								</form>
							</td>
						</tr>
					</tfoot>
				</table>
			<% } else { %>
				<h3 style="text-align: center;">관리자에게 문의하세요.(xxx-xxxx-xxxx)</h3>
			<% }
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