<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	 function fn_title(f) {
		f.action ='/22_MYBATIS/searchTitle.do';
		f.submit();
	}
	

</script>
</head>
<body>
	<form>
		검색어 <input type = "text" name ="q"/><br/><br/>
		<input type="button" value="제목검색" onclick="fn_title(this.form)"/>
		>		
	</form>
</body>
</html>