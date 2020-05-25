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
   int age = Integer.parseInt(request.getParameter("age"));//DB의 age필드가 NUMBER이므로 반드시 INT로수정해야한다.
   String address = request.getParameter("address");
   
   	Connection conn =null;
   	PreparedStatement ps= null;
   	String sql =null;
   	int result =0;
   	
   	try{
   		conn =DBConnect.getConndection();
   		sql ="INSERT INTO RED (NO, ID , PW, NAME ,AGE ,ADDRESS,REGDATE)VALUES" +
   				"(RED_SEQ.NEXTVAL,?,?,?,?,?,SYSDATE)";
   		ps =conn.prepareStatement(sql);
   		ps.setString(1, id);
   		ps.setString(2, pw);
   		ps.setString(3, name);
   		ps.setInt(4, age);
   		ps.setString(5, address);   		
   		result = ps.executeUpdate();//insert update delete 문은실행된 개수가 반환,실패시 0이반환
   		
   		if(result > 0){
   			//삽입되면 DB가 수정된 상태이기 떄문에 
   			//redirect로 페이지를 이동한다.
   			response.sendRedirect("/03_CRUD/list.jsp");
   		}
   	}catch(Exception e){
   		//삽입에 실패해도 전체 목록으로 이동한다.
   		response.sendRedirect("/03_CRUD/list.jsp");
   	}finally{
   		try {
			if( ps!= null){ps.close();};
			if(conn != null) {conn.close();}
		}catch (Exception e) {

		}
   		
   	}
   %> 