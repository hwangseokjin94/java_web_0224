<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 동적인 페이지 포함 -->
<jsp:include page="/template/header.jsp">
	<jsp:param value="마이페이지" name="title" />
</jsp:include>

<style type="text/css">
	.my-box table {
		border-collapse: collapse;
		width: 600px;
		margin: auto;
	}
	.my-box table td {
		border: 1px solid black;
		padding: 5px;		
	}
	.my-box table tbody td:first-of-type { width: 100px; }
	.my-box table tbody td:last-of-type { text-align: left; }
	.my-box table tfoot td {
		text-align: center;
	}
</style>

<script type="text/javascript">
	
	$(document).ready(function(){
		
		// 1. 비밀번호수정하기
		$('#changePwBtn').click(function(){
			location.href = '/MYHOME/changePwPage.member?mId=' + $('#mId').val();
		});
		
		// 2. 회원정보수정하기
		$('#updateBtn').click(function(){
			$.ajax({
				url: '/MYHOME/Update.member',
				type: 'POST',
				dataType: 'JSON',
				data: $('#f').serialize(),
				success: function( responseObject ) {
					if ( responseObject.result == 'SUCCESS' ) {
						alert('회원 정보가 수정되었습니다.');
					} else {
						alert('회원 정보가 수정되지 않았습니다.');
					}
					location.href = '/MYHOME/myPage.member';
				},
				error: function(){
					alert('AJAX 통신에 실패했습니다.');
				}
			});
		});
		
	});
	
</script>

<div class="my-box">
	<h1>마이페이지</h1>
    <form id="f" method="POST">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input id="mId" type="text" name="mId" value="${loginDTO.mId}" readonly /></td>
				</tr>
				<tr>
					<td>성명</td>
					<td><input id="mName" type="text" name="mName" value="${loginDTO.mName}" /></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input id="mEmail" type="text" name="mEmail" value="${loginDTO.mEmail}" /></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input id="mPhone" type="text" name="mPhone" value="${loginDTO.mPhone}" /></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input id="mAddress" type="text" name="mAddress" value="${loginDTO.mAddress}" /></td>
				</tr>
				<tr>
					<td>가입일</td>
					<td>${loginDTO.mRegdate}<!-- <input id="mRegdate" type="text" name="mRegdate" value="${loginDTO.mRegdate}" readonly /> --></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input id="updateBtn" type="button" value="회원정보수정하기" />
						<input id="changePwBtn" type="button" value="비밀번호수정하기" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div>

<!-- 정적인 페이지 포함 -->
<%@ include file="/template/footer.jsp" %>