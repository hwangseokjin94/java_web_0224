<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결제 화면</h1>
	<br/><br/><br/>
	<h3>장바구니 목록</h3>
	<%
		ArrayList<Map> cart =(ArrayList<Map>)session.getAttribute("CART") ;
	if(cart == null ){
		
		out.println("장바구니가 비었습니다.");
	}else{
		for(Map map : cart){
			Set<String> set = map.keySet();
			Iterator<String> itr = set.iterator();
			while(itr.hasNext()) {
				String product = itr.next();
				Integer quantity = (Integer)map.get(product);
				out.println(product +"&nbsp;&nbsp;" +quantity+"개");
			}
		}
	}
	
		
	%>
</body>
</html>