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
<style type="text/css">
td,th{
border: 1px solid black;
padding: 50px;
}

</style>
<title>Insert title here</title>

</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

 	String id =request.getParameter("id");
 	
 	Connection conn = null ; 
 	PreparedStatement ps = null;
 	ResultSet rs =null;
 	String sql = null;
 	try {
 		conn = DBConnect.getConnection();
 		sql = "SELECT * FROM GREEN" ; 
 		ps = conn.prepareStatement(sql);
 		/* ps.setString(1, (String)session.getAttribute("ID")); */
 		
 		rs = ps.executeQuery();
		
 
 	
 %>
 	<h3>관리자페이지</h3>
 		<table>
 		<thead>
 			<tr>
 				<th colspan="3">회원정보목록</th>
 			</tr>
 			<tr>
 				<th>아이디</th>
 				<th>성명</th>
 				<th>삭제여부</th>
 			</tr>
 		</thead>
 		<tbody>
 			<%  if ( !rs.next()) { %>
 				<tr>
 					<td colspan="6">RED 회원이 없다.</td>
 				</tr>
 			<%}else{ %>
 				<% do{ %>
 					<tr>
 						<td><a href="view.jsp?id=<%=rs.getString("ID") %>"><%=rs.getString("ID") %></a></td>
 						<td><%=rs.getString("NAME") %></td>
 						<td><a href="removeConfirm.jsp?id=<%=rs.getString("ID") %>">삭제</a></td>
 																
 					</tr>
 				<%}while(rs.next()); %>
 			<%}//if %>		
 		</tbody>
 	</table>
 
  <%
  session.setAttribute("ID", id);
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