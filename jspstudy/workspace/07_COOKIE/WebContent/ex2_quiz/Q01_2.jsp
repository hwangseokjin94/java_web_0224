<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		response.addCookie(new Cookie("ID",URLEncoder.encode(id,"utf-8")));
		response.addCookie(new Cookie("PW",URLEncoder.encode(pw,"utf-8")));
		response.addCookie(new Cookie("NAME",URLEncoder.encode(name,"utf-8")));
		
	%>

    <h3>연락처를 입력하세요.</h3>
    <form action="Q01_3.jsp" method="POST">
        <table>
            <tr>
                <td>주소</td>
                <td><input type="text" name="address" /></td>
            </tr>
            <tr>
                <td>전화번호</td>
                <td><input type="text" name="phone" /></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email" /></td>
            </tr>
        </table>
        <br/><br/>
        <input type="submit" value="확인" />
    </form>
</body>
</html>