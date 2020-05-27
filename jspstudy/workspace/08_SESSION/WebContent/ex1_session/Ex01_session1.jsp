<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	 function fn_save(f) {
		f.action = 'Ex01_session2.jsp';
		f.submit(); /*name ="data" 파라미터가저감 */
		
	}
	 
	function fn_init(f) {
		location.href = 'Ex01_session3.jsp';      /* 파라미터를 가저가지않는다. */
		
		//location.href = 'Ex01_session3.jsp?data='+f.data.value;
				
		
	}
 
</script>
</head>
<body>

	<h1>세션 관리하기</h1>
	
	<form method="POST">
			세션에 저장할 데이터 <input type="text" name ="data"/>
			<br/><br/>
			<input type="button" value="저장하기" onclick= "fn_save(this.form)" />
			
			<input type="button" value="세션초기화하기" onclick="fn_init(this.form)" />
	</form>
	<%
		//session 에 저장된 DATA 속성 확인하기
		String data = null;
		if(session.getAttribute("DATA") == null){
			data = "없음";
			
		}else{
			data = (String)session.getAttribute("DATA");
			/* getAttribute으로 꺼내려면 오브젝트이기떄문에 캐스팅해야됨 */
		}
	%>

	<h1>세션 확인하기</h1>
	세션에 저장된 정보 : <%=data %>

</body>
</html>