<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>개인정보를 입력하세요.</h3>
    <form action="Q01_2.jsp" method="POST">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" name="id" /></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="pw" /></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" name="name" /></td>
            </tr>
        </table>
        <br/><br/>
        <input type="submit" value="확인" />
    </form>
</body>
</html>