<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function fn_memberDelete(f) {
	f.action='delete';
	f.submit();
}

</script>
</head>
<body>
	
	${mDTO.mNo}번 회원입니다.<br/><br/>
	아이디:${mDTO.mId}<br/><br/>
	이름:${mDTO.mName}<br/><br/>
	<form action="update" method="post">
	아이디<input type="text" name="mId" value="${mDTO.mId}"readonly="readonly"/> <br/>
	이름<input type="text" name="mName"value="${mDTO.mName}"/> <br/>
	<input type="hidden" name="mNo" value="${mDTO.mNo}"/> <br/>
	<input type="submit" value="수정하기"/>
	<input type="button" value="삭제하기" onclick="fn_memberDelete(this.form)"/>
	<input type="button" value="전체목록보기" onclick="location.href='listPage'"/>
	</form>
	
</body>
</html>