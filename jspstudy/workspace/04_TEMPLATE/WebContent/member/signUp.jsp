<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8");%>
<!-- 동적페이지 포함 : 파라미터를 전달할수 있다. -->
<jsp:include page="../template/header.jsp">
	<jsp:param value="회원가입" name="title"/>
</jsp:include>

	
	<div class ="main-menu">
		회원가입화면
	</div>


<!--정적페이지 포함   -->
	<!-- ..상위폴더   . 현재폴더 -->
<%@ include file="../template/footer.jsp" %>
	