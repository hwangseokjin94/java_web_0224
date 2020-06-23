<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<input type="button" value="view01" onclick="location.href='v01'">
<!--@RequestMapping("v01")으로 이동하는 방법이다.  -->
<input type="button" value="view02" onclick="location.href='v02'">

</body>
</html>
