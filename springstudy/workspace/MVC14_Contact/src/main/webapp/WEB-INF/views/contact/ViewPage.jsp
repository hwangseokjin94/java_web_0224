<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_update(f){
		if(confirm('수정하시겠어요?')){
			f.aciton='update';
			f.submit();
		}
	}
	function fn_delete(f){
		if(confirm('삭제하시겠어요?')){
			f.aciton='delete';
			f.submit();
		}
	}

</script>
</head>
<body>


<table border="1">
	<h3>${cDTO.cNo}번째 정보입니다.</h3>
	<thead>
	<tr>
		<td>번호</td>		
		<td>이름</td>		
		<td>연락처</td>		
		<td>주소</td>		
		<td>이메일</td>		
		<td>비고</td>		
	</tr>
	</thead>
	<tbody>	
	<tr>
		<td>${cDTO.cNo}</td>		
		<td>${cDTO.cName}</td>		
		<td>${cDTO.cPhone}</td>		
		<td>${cDTO.cAddress}</td>		
		<td>${cDTO.cEmail}</td>		
		<td>${cDTO.cNote}</td>		
	</tr>
	</tbody>
</table>

<form method="POST">
	<h3>${cDTO.cNo}번째 정보를수정하고 버튼을눌러주세요</h3>
		>
		<input type="text" name="cName" value="${cDTO.cName}"><br/>		
		<input type="text" name="cPhone" value="${cDTO.cPhone}"><br/>		
		<input type="text" name="cAddress" value="${cDTO.cAddress}"><br/>		
		<input type="text" name="cEmail" value="${cDTO.cEmail}"><br/>		
		<input type="text" name="cNote" value="${cDTO.cNote}"><br/>			
		
	<input type="hidden" name="cNo" value="${cDTO.cNo}">		
	<input type="reset" value="다시작성하기"/><br/>
	<input type="button" value="수정하기" onclick="fn_update(this.form)"/><br/>
	<input type="button" value="삭제하기" onclick="fn_delete(this.form)"/><br/>
	<input type="button" value="목록으로이동" onclick="location.href='ContactViewPage'"/><br/>
</form>
</body>
</html>