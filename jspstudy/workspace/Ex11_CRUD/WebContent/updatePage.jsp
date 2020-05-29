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
</head>
<body>
  <%
 	Connection conn = null ; 
 	PreparedStatement ps = null;
 	ResultSet rs =null;
 	String sql = null;
 	
 	try {
 		conn = DBConnect.getConnection();
 		sql = "SELECT * FROM GREEN ORDER BY NO DESC" ; 
 		ps = conn.prepareStatement(sql);
 		rs = ps.executeQuery();
		
 
 	
 %>
 
 <table>
 <tr>
 	<td colspan="2">개인정보수정</td>
 </tr>
 <%  if ( !rs.next()) { %>
 <tr>
 		<td colspan="2">RED 회원이 없다.</td>
 </tr>
 <%}else{ %>
 <% do{ %>
 <tr>
 	<td >아이디</td> 	
 	<td ><%=rs.getString("ID") %></td> 	
 </tr>
 	<%}while(rs.next()); %>
 			<%}//if %>		
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