<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		
	+ :  ${param.a +param.b}<br/>
	- :  ${param.a - param.b}<br/>
	* :  ${param.a * param.b}<br/>
	/ :  ${param.a / param.b}<br/>

	div(나누기) : ${param.a div param.b }<br/>	
	mod)나머지) : ${param.a mod param.b }<br/>
	
	&gt; ${param.a gt param.b }<br/> <!-- > -->
	&ge; ${param.a ge param.b }<br/> <!-- >= -->
	&lt; ${param.a lt param.b }<br/> <!-- < -->
	&le; ${param.a le param.b }<br/> <!-- <= -->
	== ${param.a eq param.b }<br/> <!-- == -->
	&ne; ${param.a ne param.b }<br/> <!-- != -->
	
	둘 다 양수 : ${param.a ge 0 and param.b ge 0 } <br/>
	하나라도 양수 :${param.a ge 0 or param.b ge 0 }<br/>
	양수가 아닌가 : ${not (param.a ge 0) }<br/>
	
	큰수 : ${param.a gt param.b ? param.a:param.b }<br/>
	
</body>
</html>