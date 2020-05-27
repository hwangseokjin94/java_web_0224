<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.naming.ldap.HasControls"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    request.setCharacterEncoding("utf-8");
    String product = request.getParameter("product");
    String quantity =request.getParameter("quantity");
    
    
    Map<String, Integer>  map= new HashMap<>();
    map.put(product , Integer.parseInt(quantity));
    
    //cart를 session에서 꺼내오기
    ArrayList<Map> cart = (ArrayList<Map>)session.getAttribute("CART");
    
    //cart가 없는 경우 : 장바구니 처음 사용
    if(cart == null ){
    	cart =new ArrayList<Map>();
    	session.setAttribute("CART", cart);
    }
    
    //cart 에 map추가
      cart.add(map);
    
    
    	
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	onload = () => {
		alert('<%=product%>을 장바구니에 추가했습니다.');
		if(confirm('장바구니로 가려면 "확인",계속하려면 "취소" 버튼을 누르세요')){
			location.href='Ex03_cart4.jsp';
		}else{
			history.back();
			
		}
	}
</script>
</head>
<body>

</body>
</html>





