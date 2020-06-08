<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	 function fn_title(f) {
		f.action ='/21_MYBATIS/searchTitle.do';
		f.submit();
	}
	 function fn_content(f) {
		f.action ='/21_MYBATIS/searchContent.do';
		f.submit();
	}
	 function fn_both(f) {
		f.action ='/21_MYBATIS/searchBoth.do';
		f.submit();
	}

</script>
</head>
<body>
	<form>
		검색어 <input type = "text" name ="q"/><br/><br/>
		<input type="button" value="제목검색" onclick="fn_title(this.form)"/>
		<input type="button" value="내용검색" onclick="fn_content(this.form)"/>
		<input type="button" value="둘다검색검색" onclick="fn_both(this.form)"/>		
	</form>
</body>
</html>