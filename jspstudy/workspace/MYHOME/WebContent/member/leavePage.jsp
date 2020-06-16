<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- 동적인 페이지 포함 -->
<jsp:include page="/template/header.jsp">
	<jsp:param value="회원탈퇴" name="title" />
</jsp:include>


<style type="text/css">
	.leave-box table {
		border-collapse: collapse;
		width: 400px;
		margin: auto;
	}
	.leave-box table td {
		border: 1px solid black;
		padding: 5px;		
	}
	.leave-box table tfoot {
		text-align: center;
	}
</style>

<script type="text/javascript">
	
	$(document).ready(function(){  // onload 이벤트
		$('#leaveBtn').click(function(){  // click 이벤트
			if ($('#mPw').val() == '') {
				alert('비밀번호를 입력하세요.');
				$('#mPw').focus();
				return false;
			}
			var mPw = ${loginDTO.mPw};
			if ($('#mPw').val() != mPw ) {
				alert('비밀본호를확인하세요.');				
				return false;
			}
			$.ajax({
				url: '/MYHOME/Leave.member',
				type: 'POST',
				dataType: 'JSON',
				data: 'mId=' + $('#mId').val(),
				success: function( responseObject ) {
					if ( responseObject.result =='SUCCESS') {
						alert('탈퇴되었습니다 이용해주셔서 감사합니다.');
						location.href='/MYHOME/index.member';
					} else {
						alert('탈퇴되지않았습니다.');
						history.back();
					}
				},
				error: function() {
					alert('AJAX 통신이 실패했습니다.');
				}
			});
			
		});
	});
	
</script>

<div class="leave-box">
	<form method="POST">
		<table>
			<tbody>
				<tr>
					<td>탈퇴 아이디</td>
					<td><input id="mId" type="text" name="mId"  value="${loginDTO.mId}" /></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input id="mPw" type="password" name="mPw" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input id="leaveBtn" type="button" value="회원탈퇴" />				
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>


<!-- 정적인 페이지 포함 -->
<%@ include file="/template/footer.jsp" %>