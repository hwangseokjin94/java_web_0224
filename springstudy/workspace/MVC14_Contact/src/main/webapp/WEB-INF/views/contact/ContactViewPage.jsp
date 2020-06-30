<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_contactUpdate(f) {
		f.action = 'contactUpdate';
		f.submit();
	}
	function fn_contactDelete(f) {
		if (confirm('삭제할까요?')) {
			f.action = 'contactDelete';
			f.submit();
		}
	}
</script>
</head>
<body>

	<div>
		<h3>${cDTO.cNo}번 연락처</h3>
		이름 : ${cDTO.cName}<br/>
		전화 : ${cDTO.cPhone}<br/>
		주소 : ${cDTO.cAddress}<br/>
		이메일 : ${cDTO.cEmail}<br/>
		비고 : ${cDTO.cNote}<br/>
	</div>
	
	<br/>
	
	<form method="post">
		<h3>정보를 수정하고 수정하기 버튼을 클릭하세요</h3>
		<input type="text" name="cName" value="${cDTO.cName}" /><br/>
		<input type="text" name="cPhone" value="${cDTO.cPhone}" /><br/>
		<input type="text" name="cAddress" value="${cDTO.cAddress}" /><br/>
		<input type="text" name="cEmail" value="${cDTO.cEmail}" /><br/>
		<input type="text" name="cNote" value="${cDTO.cNote}" /><br/>
	
		<input type="hidden" name="cNo" value="${cDTO.cNo}" />
		<input type="button" value="수정하기" onclick="fn_contactUpdate(this.form)" />
		<input type="button" value="삭제하기" onclick="fn_contactDelete(this.form)" />
	</form>

</body>
</html>