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
</head>
<body>
 <%
 	Connection conn = null ; 
 	PreparedStatement ps = null;
 	ResultSet rs =null;
 	String sql = null;
 	
 	try {
 		conn = DBConnect.getConndection();
 		sql = "SELECT * FROM RED ORDER BY NO DESC" ; // no 내림차순의 목록
 		ps = conn.prepareStatement(sql);
 		rs = ps.executeQuery();//select 문 전용 메소드
		
 
 	
 %>
 
 
 <div class="wrap">
 	<h1>테이블 전체목록</h1>
 	<table>
 		<thead>
 			<tr>
 				<th>번호</th>
 				<th>아이디</th>
 				<th>성명</th>
 				<th>나이</th>
 				<th>주소</th>
 				<th>가입일</th>
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
 						<td><%=rs.getInt("NO") %></td>
 						<td><%=rs.getString("ID") %></td>
 						<td><%=rs.getString("name") %></td>
 						<td><%=rs.getInt("AGE") %></td>
 						<td><%=rs.getString("ADDRESS") %></td>
 						<td><%=rs.getDate("REGDATE") %></td>
 						
 					</tr>
 				<%}while(rs.next()); %>
 			<%}//if %>		
 		</tbody>
 	</table>
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