<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    
    <%
    
    	session.invalidate(); //USER CART 모두삭제
    	response.sendRedirect("Ex03_cart1.jsp");
    %>
