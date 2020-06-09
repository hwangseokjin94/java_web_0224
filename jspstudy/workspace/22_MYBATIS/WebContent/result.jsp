<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.wrap{
	width: 1200px;
	margin: auto;
	}
	table{
	width: 1000px;
	border-collapse: collapse;
	margin: auto;
	}
	th,td{
	border: 1px solid black;
	padding: 3px;
	text-align: center;
	}
	h3{
	text-align: center;
	}
</style>
</head>
<body>
	<div class = "wrap">
		<h3><span style="color: red;">${TYPE }</span>검색결과 목록</h3>
		
		<table>
			<thead>
			<tr>
				<th>사원ID</th>
				<th>LAST_NAME</th>
				<th>FIRST_NAME</th>
				<th>연락처</th>
				<th>연봉</th>
				<th>부서ID</th>
				<th>직업ID</th>
				<th>고용일</th>		
				
			</tr>
			
			</thead>
			<tbody>
				<c:if test="${empty LIST }">
					<tr>
						<td colspan="8">직원이없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty LIST}">
					<c:forEach var="eDTO" items="${LIST}">
						<tr>
							<td>${eDTO.employee_id}</td>
							<td>${eDTO.last_name}</td>
							<td>${eDTO.first_name}</td>
							<td>${eDTO.phone_number}</td>
							
							<td><fmt:formatNumber value="${eDTO.salary}" pattern="#,##0만원" /></td>
							<td>${eDTO.department_id}</td>
							<td>${eDTO.job_id}</td>
							<td><fmt:formatDate value="${eDTO.hire_date}" pattern="yyyy년 MM월 dd일 E요일"/></td>
						</tr>	
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>