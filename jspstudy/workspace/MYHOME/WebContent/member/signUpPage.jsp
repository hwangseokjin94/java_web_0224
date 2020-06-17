<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 동적인 페이지 포함 -->
<jsp:include page="/template/header.jsp">
	<jsp:param value="회원가입" name="title" />
</jsp:include>

<style type="text/css">
	.sign-up-box table {
		border-collapse: collapse;
		width: 600px;
		margin: auto;
	}
	.sign-up-box table td {
		border: 1px solid black;
		padding: 5px;		
	}
	.sign-up-box table tbody td:first-of-type { width: 100px; }
	.sign-up-box table tbody td:last-of-type { text-align: left; }
	.sign-up-box table tfoot td {
		text-align: center;
	}
</style>

<script type="text/javascript">
	
	$(document).ready(function(){
		
		// 1. 아이디 중복 체크
		//    5 ~ 20 사이의 소문자나 숫자를 사용한다. 첫 글자는 소문자이다.
		var regExpID = /^[a-z][a-z0-9]{4,19}$/;  // 첫 글자는 소문자이다.(^[a-z]+)
		
		$('#mId').keyup(function(){
			$.ajax({
				url: '/MYHOME/IdCheck.member',
				type: 'POST',
				dataType: 'JSON',
				data: 'mId=' + $('#mId').val(),
				success: function( responseObject ) {
					// 정규식 test()
					if ( regExpID.test($('#mId').val()) ) {  // 정규식을 만족하면,
						// 가입된 아이디인지 여부 확인
						if ( responseObject.result == 'EXIST' ) {
							$('#idCheckResult').text('이미 가입된 아이디입니다.');
							$('#idCheckResult').css('color', 'red');
						} else {
							$('#idCheckResult').text('사용할 수 있는 아이디입니다.');
							$('#idCheckResult').css('color', 'blue').css('font-weight', 'bold');
						}
					} else {  // 정규식을 만족하지 않으면
						$('#idCheckResult').text('5~20자, 소문자시작, 소문자+숫자 가능');
						$('#idCheckResult').css('color', 'red');
					}
				},
				error: function() {
					alert('AJAX 통신이 실패했습니다.');
				}
			});
		});
		
		// 2. 비밀번호 체크
		//    8 ~ 20 사이의 대문자, 소문자, 숫자, 특수문자(~!@#$%^&*)를 사용한다.
		//    각각 1개 이상 포함해야 한다.
		var regExpPW = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*])[A-Za-z0-9~!@#$%^&*]{4,20}$/;
		
		$('#mPw').keyup(function() {
			if ( regExpPW.test($('#mPw').val()) ) {
				$('#pwCheckResult').text('비밀번호 사용 가능합니다.');
				$('#pwCheckResult').css('color', 'blue').css('font-weight', 'bold');
			} else {
				$('#pwCheckResult').text('4~20자, 대문자, 소문자, 숫자, 특수문자(~!@#$%^&*) 포함');
				$('#pwCheckResult').css('color', 'red');
			}
		});
		
		$('#mPw2').keyup(function() {
			if ( $('#mPw').val() != $('#mPw2').val() ) {
				$('#pwConfirmResult').text('비밀번호가 일치하지 않습니다.');
				$('#pwConfirmResult').css('color', 'red');
			} else {
				$('#pwConfirmResult').text('비밀번호가 일치합니다.');
				$('#pwConfirmResult').css('color', 'blue').css('font-weight', 'bold');
			}
		});
		
		
		// 3. 이메일
		
		var regExpEMAIL = /^[a-z][a-z0-9\-\_]+@[A-Za-z0-9]{3,}(\.[A-Za-z]{2,6}){1,2}$/;
		
		$('#mEmail').keyup(function() {
			$.ajax({
				url: '/MYHOME/EmailCheck.member',
				type: 'POST',
				dataType: 'JSON',
				data: 'mEmail=' + $('#mEmail').val(),
				success: function( responseObject ) {
					// 정규식 test()
					if ( regExpEMAIL.test($('#mEmail').val()) ) {
						// 가입된 이메일 여부 확인
						if ( responseObject.result == 'EXIST' ) {
							$('#emailCheckResult').text('이미 가입된 이메일입니다.');
							$('#emailCheckResult').css('color', 'red');
						} else {
							$('#emailCheckResult').text('사용할 수 있는 이메일입니다.');
							$('#emailCheckResult').css('color', 'blue').css('font-weight', 'bold');
						}
					} else {  // 정규식을 만족하지 않으면
						$('#emailCheckResult').text('올바른 이메일 형식이 아닙니다.');
						$('#emailCheckResult').css('color', 'red');
					}
				},
				error: function() {
					alert('AJAX 통신이 실패했습니다.');
				}
			});
			
		});
		
		// 4. 전화번호(핸드폰)
		var regExpPHONE = /^01[0|1|6|9]-[0-9]{3,4}-[0-9]{4}$/;
		
		$('#mPhone').keyup(function(){
			if ( regExpPHONE.test($('#mPhone').val()) ) {
				$('#phoneCheckResult').text('사용 가능한 번호입니다.');
				$('#phoneCheckResult').css('color', 'blue').css('font-weight', 'bold');
			} else {
				$('#phoneCheckResult').text('올바른 전화번호 형식이 아닙니다.');
				$('#phoneCheckResult').css('color', 'red');
			}
		});
		
		// 5. 회원가입
		$('#signUpBtn').click(function(){
			$.ajax({
				url: '/MYHOME/SignUp.member',
				type: 'POST',
				dataType: 'JSON',
				data: $('#f').serialize(),
				success: function( responseObject ) {
					if ( responseObject.result == 'SUCCESS' ) {
						alert('회원 가입에 성공했습니다.');
						location.href = '/MYHOME/loginPage.member';
					} else {
						alert('가입되지 않았습니다.');
					}
				},
				error: function(){
					alert('AJAX 통신이 실패했습니다.');
				}
			});
		});
		
		// 6. 입력 초기화
		$('#clearBtn').click(function(){
			$('input[type=text], input[type=password]').each(function(){
				//  각 요소는 each 문 내부에서 $(this) 로 호출한다.
				$(this).val('');
			});
			$('span').each(function(){
				$(this).text('');
			});
			$('#mId').focus();
		});
		
		
	});
	
</script>

<div class="sign-up-box">
	<h1>회원가입</h1>
    <form id="f" method="POST">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td>
						<input id="mId" type="text" name="mId" autocomplete="off" /><br/>
						<span id="idCheckResult"></span>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input id="mPw" type="password" name="mPw" /><br/>
						<span id="pwCheckResult"></span>
					</td>
				</tr>
				<tr>
					<td>비밀번호확인</td>
					<td>
						<input id="mPw2" type="password" name="mPw2" /><br/>
						<span id="pwConfirmResult"></span>
					</td>
				</tr>
				<tr>
					<td>성명</td>
					<td><input id="mName" type="text" name="mName" /></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input id="mEmail" type="text" name="mEmail" /><br/>
						<span id="emailCheckResult"></span>
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>
						<input id="mPhone" type="text" name="mPhone" placeholder="하이픈입력" /><br/>
						<span id="phoneCheckResult"></span>
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input id="mAddress" type="text" name="mAddress" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input id="signUpBtn" type="button" value="회원가입" />
						<input id="clearBtn" type="reset" value="입력취소" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>

<!-- 정적인 페이지 포함 -->
<%@ include file="/template/footer.jsp" %>