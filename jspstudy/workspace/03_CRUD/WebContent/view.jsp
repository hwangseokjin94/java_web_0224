<%@page import="java.text.SimpleDateFormat"%>
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
<title>Insert title here</title>
<link style="text/css" rel ="stylesheet" href="assets/style/common.css">
<style type="text/css">
	thead > tr:first-of-type {
		color: white;
		background: red;
	}
	tfoot > tr:first-of-type {
		text-align: center;
	}
	td:nth-of-type(1) {
	width: 150px;
	}
	td:nth-of-type(2) {
	width: 600px;
	}
</style>

</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		Connection conn =null;
		PreparedStatement ps = null ; 
		ResultSet rs =null;
		String sql =null;
		
		try{
			conn =DBConnect.getConndection();
			sql = "SELECT * FROM RED WHERE ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs =ps.executeQuery();					
		
	%>
	
	<div class="wrap">
		<form method ="post">
			<table>
				<thead>
					<tr>
						<th colspan="2"><%=id %> 님 정보</th>
					</tr>
				</thead>
				<tbody>
					<%if(rs.next() ){ %>
						<tr>
							<td>번호</td>
							<td><%=rs.getInt("NO") %>
						</tr>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="id" value ="<%=rs.getString("ID") %>" readonly /></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="pw" value="<%=rs.getString("PW") %>" /></td>
						</tr>
						<tr>
							<td>성명</td>
							<td><input type="text" name="name" value="<%=rs.getString("NAME") %>" /></td>
						</tr>
						<tr>
							<td>나이</td>
							<td><input type="text" name="age"value="<%=rs.getInt("AGE")%>"  /></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><input type="text" name="address"value="<%=rs.getString("ADDRESS") %>"  /></td>
						</tr>
						<tr>
							<td>가입일</td>
							<td><input type="text" name="address"value="<%=(new SimpleDateFormat("yyy/MM/dd E요일 a hh:mm:ss")).format(rs.getDate("REGDATE")) %>"  readonly /></td>
						</tr>
						<%}else {%>
							<tr>
								<td colspan="2">
								<%=id %> 님의 정보가 없습니다.
								</td>
							</tr>
						<%} %>
						
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="수정하기" onclick="fn_update(this.form)" />
							<input type="reset" value="다시작성하기"  />
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	 <%
 	}catch(Exception e){
 		e.printStackTrace();
 		
 	}finally{
 		try{
 			if(rs != null ){rs.close();}
 			if(ps != null ){ps.close();}
 			if(conn != null ){conn.close();}
 		}catch(Exception e){
 			
 		}
 	}
 %>
</body>
</html>