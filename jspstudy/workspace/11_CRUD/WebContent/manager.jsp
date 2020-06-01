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
<title>관리자 페이지</title>
<style type="text/css">
	body {
		text-align: center;
	}
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
</head>
<body>
	<h1 style="text-align: center;">관리자 페이지</h1>
	<%
		// session 에 저장된 "LOGIN_CHK" 속성을 확인한다.
		String result = (String)session.getAttribute("LOGIN_CHK");
		
		if ( result == null ) { %>
			<script type="text/javascript">
				alert("로그인이 필요합니다. 로그인하세요.");
				location.href = "loginPage.jsp";
			</script> <%
		} else if ( result.equals("OK") ) {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = null;
			
			try {
				conn = DBConnect.getConnection();
				sql = "SELECT * FROM GREEN ORDER BY ID";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();  %>
				<table>
					<thead>
						<tr>
							<th>아이디</th>
							<th>성명</th>
							<th>삭제여부</th>
						</tr>
					</thead>
					<tbody>
						<% if ( rs.next() ) { %>
							<% do { %>
								<tr>
									<td><a href="view.jsp?id=<%=rs.getString("id") %>"><%=rs.getString("id") %></a></td>
									<td><%=rs.getString("name") %></td>
									<td><a href="removePage.jsp?id=<%=rs.getString("id") %>">삭제</a></td>
								</tr>
							<% } while ( rs.next() ); %>
						<% } else { %>
							<tr>
								<td colspan="3">검색된 회원이 없습니다.</td>
							</tr>
						<% } %>
					</tbody>
				</table> <%
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
		}
	%>
</body>
</html>