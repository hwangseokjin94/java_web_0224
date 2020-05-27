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
	
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		response.addCookie(new Cookie("ADDRESS",URLEncoder.encode(address,"utf-8")));
		response.addCookie(new Cookie("PHONE",URLEncoder.encode(phone,"utf-8")));
		response.addCookie(new Cookie("EMAIL",URLEncoder.encode(email,"utf-8")));
		
	%>
    <h3>추가정보를 입력하세요.</h3>
    <form action="Q01_4.jsp" method="POST">
        <table>
            <tr>
                <td>생년월일</td>
                <td>
                    <input type="text" name="birthYear" size="6" />년 
                    <input type="text" name="birthMonth" size="3" />월 
                    <input type="text" name="birthDay" size="3" />일 
                </td>
            </tr>
            <tr>
                <td>결혼여부</td>
                <td>
                    <input type="radio" name="marriage" value="no" /> 미혼 
                    <input type="radio" name="marriage" value="yes" /> 기혼 
                </td>
            </tr>
            <tr>
                <td>직업</td>
                <td>
                    <select name="job">
                        <option value="salaryman">회사원</option>
                        <option value="developer">개발자</option>
                        <option value="doctor">의사</option>
                        <option value="etc">기타</option>
                    </select>
                </td>
            </tr>
        </table>
        <br/><br/>
        <input type="submit" value="확인" />
    </form>
</body>
</html>