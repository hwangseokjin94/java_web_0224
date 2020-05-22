<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	onload = () => {
		var etc_chk = document.querySelector('#etc_chk');  // checkbox
		etc_chk.addEventListener('click', () => {
			var f = document.forms.myForm;
			if ( f.hobbies[3].checked ) {
				f.etc.focus();  // f.etc (<input type="text" name="etc" />)
			}
		});
	}

	function fn_send(f) {
		f.action = "Ex03_to.jsp";  // 같은 경로이므로 파일명만으로 이동이 가능하다.
		f.submit();
	}
	
</script>
</head>
<body>
	<form name="myForm" method="POST">
	
		<fieldset style="width: 500px;">

			<legend>회원가입 양식</legend>

			<label for="id">아이디</label>
			<input type="text" name="id" id="id" /><br/>

			<label for="pw">비밀번호</label>
			<input type="password" name="pw" id="pw"/><br/>

			<input type="radio" name="gender" value="남자" id="male" checked />
			<label for="male">남</label>
			<input type="radio" name="gender" value="여자" id="female" />
			<label for="female">여</label><br/>
			
			<input type="checkbox" name="hobbies" value="영화" id="movie" checked />
			<label for="movie">영화</label>
			<input type="checkbox" name="hobbies" value="여행" id="travel" />
			<label for="travel">여행</label>
			<input type="checkbox" name="hobbies" value="운동" id="fitness" />
			<label for="fitness">운동</label>
			<input type="checkbox" name="hobbies"  id="etc_chk" />
			<label for="etc_chk">기타</label>
			<input type="text" name="etc" /><br/>
			
			<select name="address">
				<option value="서울">서울</option>
				<option value="부산">부산</option>
				<option value="대구">대구</option>
				<option value="제주">제주</option>
			</select><br/>
			
			<select name="jobs" multiple>
				<option value="작가">작가</option>
				<option value="의사">의사</option>
				<option value="프로그래머">프로그래머</option>
				<option value="주부">주부</option>
			</select><br/>
			
			<textarea name="memo" rows="5" cols="50"></textarea><br/>
			
			<input type="hidden" name="height" value="180.5" />
			<input type="hidden" name="weight" value="85.5" />
			
			<!-- 중요. button 을 사용하면 form 태그의 action 속성과 onsubmit 속성을 사용하지 않는다. -->
			
			<input type="button" value="전송" onclick="fn_send(this.form)" />
			
		</fieldset>
		
	</form>
</body>
</html>