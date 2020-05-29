<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<title>Insert title here</title>
<script type="text/javascript">
//fn_join 회원가입 데이터입력여부확인
	function fn_join(f) {
		if(f.pw.value=='' ||  f.pw.value != f.pw2.value){
			alert('비밀번호를 입력하시고 2차와 일치한지 확인하세요');
			return;
		}
		if(f.name.value == ''){
			alert('성명은필수입니다.');
			f.name.focus();
			return;
		}
		if(f.age.value == ''){
			alert('성명은필수입니다.');
			f.name.focus();
			return;
		}
		f.action = 'join.jsp';
		f.submit();
	}

</script>
</head>
<body>
	<h3>회원가입페이지</h3>
	
	<form >
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name ="id"><input type="button" value="중복확인" onclick="fn_id"></td>
		</tr>	
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name ="pw"></td>
		</tr>	
		<tr>
			<td>비밀번호확인</td>
			<td><input type="password" name ="pw2"></td>
		</tr>	
		<tr>
			<td>나이</td>
			<td><input type="text" name ="age"></td>
		</tr>	
		<tr>
			<td>주소</td>
			<td><select name="address">
					<option  value="서울">서울</option>
					<option value="경기">경기</option>
					<option value="인천">인천</option>
					<option  value="부산">부산</option>
					<option value="제주">제주</option>
				</select></td>
		</tr>	
		<tr>
			<td colspan="3">
				<input type="button" value="가입" onclick="location.href = fn_join(this.form)"/>
				<input type="reset" value="취소"/>
				<input type="submit" value="로그인하러가기" onclick="location.href='loginPage.jsp'"/>
															
			</td>

	
		</tr>	
	</table>
	</form>
</body>
</html>