<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- 동적인 페이지 포함 -->
<jsp:include page="/template/header.jsp">
	<jsp:param value="아이디찾기" name="title" />
</jsp:include>


<style type="text/css">
	.find-id-box table {
		border-collapse: collapse;
		width: 400px;
		margin: auto;
	}
	.find-id-box table td {
		border: 1px solid black;
		padding: 5px;		
	}
	.find-id-box table tfoot {
		text-align: center;
	}
</style>

<script type="text/javascript">
	
	// AJAX 를 통해 아이디를 찾는다.
	$(document).ready(function(){
		$('#findIdBtn').click(function(){
			$.ajax({
				url: '/MYHOME/FindId.member',
				type: 'POST',
				dataType: 'text',
				data: 'mEmail=' + $('#mEmail').val(),
				success: function(responseText) {
					if ( responseText.trim() != "NO" ) {
						$('#findIdResult').text('회원님의 아이디는 ' + responseText + '입니다.');
						$('#findIdResult').css('color', 'blue').css('font-weight', 'bold');
					} else {
						$('#findIdResult').text('일치하는 회원 정보가 없습니다.');
						$('#findIdResult').css('color', 'red').css('font-weight', 'bold');
					}
				},
				error: function() {
					alert('AJAX 통신이 실패했습니다.');
				}
			});
		});
	});
	
</script>


<div class="find-id-box">
	<form method="POST">
		<table>
			<tbody>
				<tr>
					<td>가입 당시 이메일</td>
					<td><input id="mEmail" type="text" name="mEmail" autofocus /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input id="findIdBtn" type="button" value="아이디찾기" />
						&nbsp;&nbsp;
						<input type="button" value="로그인하러 가기" onclick="location.href='/MYHOME/loginPage.member'" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	<br/><br/>
	<div id="findIdResult"></div>  <!-- AJAX 처리 결과가 나타나는 위치이다. -->
</div>


<!-- 정적인 페이지 포함 -->
<%@ include file="/template/footer.jsp" %>