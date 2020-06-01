<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴 확인 페이지</title>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
%>

<script type="text/javascript">

	window.onload = function() {
		if ( confirm("탈퇴할까요?") ) {
			location.href = "remove.jsp?id=<%=id %>";
		} else {
			alert("취소되었습니다.");
			location.href = "manager.jsp";
			// 또는 history.back();
		}
	}

</script>
</head>
<body>

</body>
</html>