<%@page import="dto.BlueDto"%>
<%@page import="dao.BlueDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	
	BlueDao bDao = BlueDao.getInstance();
	BlueDto bDto = bDao.view(id);
	
	pageContext.setAttribute("BDTO", bDto); //EL의 사용을 위해 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	 function fn_pwConfirm(f) {
		 f.action = 'pwConfirm.jsp';
		 f.submit();
		
	}
	function fn_emailConfirm(f) {
		f.action = 'emailConfirm.jsp';
		f.submit();
	}

</script>
</head>
<body>
	<c:if test="${BDTO eq null }">
		<script type="text/javascript">
			alert('회원정보가 없습니다. 다시 확인하세요.');
			history.back();
		</script>
	</c:if>
	<c:if test="${BDTO ne null }">
	<form method="POST">	
			<table>
				<thead>
					<tr>
						<td colspan="2">${BDTO.name }님의 정보입니다.</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>번호</td>				
						<td>${BDTO.no }</td>				
					</tr>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id" value="${BDTO.id }"readonly/></td>
					</tr>
					<tr>
						<td>성명</td>				
						<td><input type="text" name="name"value="${BDTO.name }"/></td>									
					</tr>
					<tr>
						<td>나이</td>				
						<td><input type="text" name="age"value="${BDTO.age }"/></td>									
					</tr>
					<tr>
						<td>이메일</td>				
						<td><input type="text" name="email"value="${BDTO.email }"/></td>									
					</tr>
					<tr>
						<td>가입일</td>				
						<td><input type="text" name="reg_date"value="${BDTO.reg_date }" readonly/></td>									
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="hidden" name="pw" value="${BDTO.pw }" />
							<input type="button" value="회원정보수정" onclick="fn_pwConfirm(this.form)"/>
							<input type="button" value="비밀번호 변경" onclick="fn_emailConfirm(this.form)"/>
							<input type="button" value="목록으로이동" onclick="location.href='list.jsp'"/>
						</td>										
					</tr>
				</tfoot>			
			</table>
		</form>
	</c:if>
	
</body>
</html>





