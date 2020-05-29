<%@page import="db.DBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%
   	request.setCharacterEncoding("utf-8");
   String id = request.getParameter("id");
   String pw = request.getParameter("pw");
   String name = request.getParameter("name");
   int age = Integer.parseInt(request.getParameter("age"));
   String address = request.getParameter("address");
   
   	Connection conn =null;
   	PreparedStatement ps= null;
   	String sql =null;
   	int result =0;
   	
   	try{
   		conn =DBConnect.getConnection();
   		sql ="INSERT INTO GREEN (IDX, ID , PW, NAME ,AGE ,ADDR,REG_DATE)VALUES" +
   				"(GREEN_SEQ.NEXTVAL,?,?,?,?,?,SYSDATE)";
   		ps =conn.prepareStatement(sql);
   		ps.setString(1, id);
   		ps.setString(2, pw);
   		ps.setString(3, name);
   		ps.setInt(4, age);
   		ps.setString(5, address);   		
   		result = ps.executeUpdate();
   		
   	/* 	if(result > 0){
   		out.println("<script>alert('회원가입 성공');</script>");
   		out.println("location.href='login.jsp'");

   		} */
   	}catch(Exception e){
   	
   		out.println("<script>alert('회원가입 실패');</script>");
   		out.println("location.href='joinPage.jsp'");

   	}finally{
   		try {
			if( ps!= null){ps.close();};
			if(conn != null) {conn.close();}
		}catch (Exception e) {

		}
   		
   	}
   %> 
    
    
    
    
    
    
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>