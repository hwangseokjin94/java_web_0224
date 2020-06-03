<%@page import="dao.WhiteDao"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
  <%
  	request.setCharacterEncoding("utf-8");
  	String id =request.getParameter("id");
  	String pw =request.getParameter("pw");
  	
  	Map<String,String> map = new HashMap<>();
  	map.put("id", id);
  	map.put("pw", pw);
  	
  	WhiteDao wDao = WhiteDao.getInstance();
  	int result = wDao.updatePw(map);
  	
  	pageContext.setAttribute("RESULT", result);	
  %>
  <c:choose>
  	<c:when test="${RESULT gt 0 }">
  		<script type="text/javascript">
  			alert('비밀번호가 정상적으로 변경되었습니다.');
  			location.href='loginPage.jsp';
  		</script>	
  	</c:when>
  	<c:otherwise>
  		<script type="text/javascript">
  			alert('비밀번호가 변경되지않았습니다.');
  			history.go(-2);
  		</script>	
  	</c:otherwise>
  </c:choose>
 