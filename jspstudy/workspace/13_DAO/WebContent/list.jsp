<%@page import="dto.BlueDto"%>
<%@page import="java.util.ArrayList"%>

<%@page import="dao.BlueDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%
    
    BlueDao bDao = BlueDao.getInstance();
    ArrayList<BlueDto> list =bDao.list();
    
    //EL의 사용을 위해 list를 pageContext에 저장한다.
    pageContext.setAttribute("LIST", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 td {
	border: 1px solid black;
	padding: 0;
	margin: center;
	width: 150px;
	height: 50px;
	text-align: center;
}
</style>
<script type="text/javascript">
	function fn_delete(f) {
		if( confirm('삭제할까요?')){
			f.action = "delete.jsp";
			f.submit();
		}		
	}
	

</script>
</head>
<body>


		<table>
			<thead>
				<tr>
					<td>번호</td>
					<td>아이디</td>
					<td>비밀번호</td>
					<td>성명</td>
					<td>나이</td>
					<td>이메일</td>
					<td>가입일</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty LIST }">
					<tr>
						<td colspan="8">BLUE회원이 없다.</td>
					</tr>
				</c:if>		
				<c:if test="${not empty LIST }">
					<c:forEach var="bDto" items="${LIST }">
						<tr>
							<td>${bDto.no }</td><!--자바파일이라서 소문자로써야됨 -->
							<td><a href="view.jsp?id=${bDto.id }">${bDto.id }</a></td>
							<td>${bDto.pw }</td>
							<td>${bDto.name }</td>
							<td>${bDto.age }</td>
							<td>${bDto.email }</td>
							<td>${bDto.reg_date }</td>
							<td>
								<form method="POST">	
									<input type="button" value="삭제" onclick="fn_delete(this.form)"/>
									<input type="hidden" name="id" value="${bDto.id }"/>	
								</form>
							</td>
													
						</tr>
					</c:forEach>
				</c:if>		
			</tbody>
		</table>
		
</body>
</html>