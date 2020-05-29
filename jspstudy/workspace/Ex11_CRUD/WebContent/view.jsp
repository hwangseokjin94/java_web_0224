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
<style type="text/css">

th,td{
	border: 1px solid black;
	margin: auto;
	
	
}


</style>
</head>
<body>
 <%
 	Connection conn = null ; 
 	PreparedStatement ps = null;
 	ResultSet rs =null;
 	String sql = null;
 	
 	try {
 		conn = DBConnect.getConnection();
 		sql = "SELECT * FROM GREEN" ; 
 		ps = conn.prepareStatement(sql);
 		rs = ps.executeQuery();
		
 
 	
 %>
 


 	<table>
 		<thead>
 		<tr ><th colspan="7">회원정보</th><tr>
 			<tr>
 				<th>회원번호</th>
 				<th>아이디</th>
 				<th>비밀번호</th>
 				<th>이름</th>
 				<th>나이</th>
 				<th>주소</th>
 				<th>가입일</th>
 			</tr>
 		</thead>
 		<tbody>
 		
 		
 		
 			<%  if ( !rs.next()) { %>
 				<tr>
 					<td colspan="7">RED 회원이 없다.</td>
 				</tr>
 			<%}else{ %>
 				<% do{ %>
 					<tr>
 						<td><%=rs.getInt("IDX") %></td>
 						<td><%=rs.getString("ID") %></td>
 						<td><%=rs.getInt("PW") %></td>
 						<td><%=rs.getString("NAME") %></td>
 						<td><%=rs.getInt("AGE") %></td> 						
 						<td><%=rs.getString("ADDR") %></td>
 						<td><%=rs.getDate("REG_DATE") %></td> 						
 					</tr>
 				<%}while(rs.next()); %>
 			<%} %>		
 			 			
 		</tbody>
 		<tr>
 			<td colspan="7">
 				<input type="button" value="리스트로이동" onclick = "location.href = 'manager.jsp'">
 				<input type="button" value="수정하기" onclick = "location.href = 'updatePage.jsp'"/>
 			</td>
 		</tr>
 	</table>

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