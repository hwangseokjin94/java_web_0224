<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">
		onload = function () {
			setTimeout(() => {
				location.href='index'; //index.jsp가 아니라@RequestMapping("index")를의미한다.
			}, 1000);
		}
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
