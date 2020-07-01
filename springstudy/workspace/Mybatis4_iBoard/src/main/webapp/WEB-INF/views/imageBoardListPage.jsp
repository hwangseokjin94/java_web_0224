<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="resources/assets/styles/style.css">

</head>
<body>
	<a href="uploadPage">새글작성하기</a><br/><br/>
	<table border="1">
	
		<thead>
			<tr>
				<td>번호</td>
				<td>이미지</td>
				<td>작성자</td>
				<td>제목</td>
				<td>내용</td>
				<td>작성일자</td>
			</tr>
		</thead>
		
		<tbody>
			<c:if test="${empty list}">
				<td colspan="6">
					없음
				</td>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="iDTO" items="${list}">
					<tr>
						<td>${iDTO.iNo}</td>
						<!-- alt="${iDTO.iFilename}"  이미지가 아닌 파일이 업로드되면 파일명이 나타난다.  -->
						<%-- <%=request.getContextPath()%>  는 ${pageContext.request.contextPath} 이다. --%>
						<td><a href="download?iFilename=${iDTO.iFilename}"><img alt="${iDTO.iFilename}" src="${pageContext.request.contextPath}/resources/storage/${iDTO.iFilename}"></a></td>
						<td>${iDTO.iWriter}</td>
						<td>${iDTO.iTitle}</td>
						<td>${iDTO.iContent}</td>
						<td>${iDTO.iRegdate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		
	</table>

</body>
</html>