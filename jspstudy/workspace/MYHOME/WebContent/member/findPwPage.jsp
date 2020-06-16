<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- 동적인 페이지 포함 -->
<jsp:include page="/template/header.jsp">
	<jsp:param value="비밀번호찾기" name="title" />
</jsp:include>


<style type="text/css">
	.find-pw-box table {
		border-collapse: collapse;
		width: 400px;
		margin: auto;
	}
	.find-pw-box table td {
		border: 1px solid black;
		padding: 5px;		
	}
	.find-pw-box table tfoot {
		text-align: center;
	}
</style>

<script type="text/javascript">
	
	$(document).ready(function(){  // onload 이벤트
		$('#findPwBtn').click(function(){  // click 이벤트
			if ($('#mId').val() == '') {
				alert('아이디를 입력하세요.');
				$('#mId').focus();
				return false;
			}
			if ($('#mPhone').val() == '') {
				alert('전화번호를 입력하세요.');
				$('#mPhone').focus();
				return false;
			}
			$.ajax({
				url: '/MYHOME/FindPw.member',
				type: 'POST',
				dataType: 'text',
				data: 'mId=' + $('#mId').val() + '&mPhone=' + $('#mPhone').val(),
				success: function( responseText ) {
					if ( responseText.trim() == 'NO' ) {
						alert('제출하신 회원 정보가 없습니다.');
					} else {
						alert('회원 정보가 확인되었습니다. 새로운 비밀번호를 설정하세요.');
						location.href = '/MYHOME/changePwPage.member?mId=' + $('#mId').val();
					}
				},
				error: function() {
					alert('AJAX 통신이 실패했습니다.');
				}
			});
			
		});
	});
	
</script>

<div class="find-pw-box">
	<form method="POST">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input id="mId" type="text" name="mId" autofocus /></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input id="mPhone" type="text" name="mPhone" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input id="findPwBtn" type="button" value="비밀번호찾기" />
						&nbsp;&nbsp;
						<input type="button" value="로그인하러 가기" onclick="location.href='/MYHOME/loginPage.member'" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>


<!-- 정적인 페이지 포함 -->
<%@ include file="/template/footer.jsp" %>