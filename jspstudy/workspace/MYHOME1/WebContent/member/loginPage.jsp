<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--동적인 페이지 포함  -->
<jsp:include page="/template/header.jsp">
	<jsp:param value="로그인" name="title"/>
</jsp:include>
<script type="text/javascript">
	function fn_login(f) {
		//아이디 비밀버놓 정규식체크
		f.action='/MYHOME/login.member';
		f.submit();
	}

</script>

<div class="login-box">
	<form action="POST">
		<table>
			<tbody>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mId" autofocus/></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="mPw"/></td>
				</tr>
			</tbody>	
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" value="로그인" onclick="fn_login(this.form)"/>
						&nbsp;&nbsp;&nbsp;
						<input type="checkbox" name="saveID" value="true" checke/>아이디기억하기
						<br/><br/>
						<a href="/MYHOME/findIdPage.member">아이디 찾기</a>
						&nbsp;&nbsp;&nbsp;
						<a href="/MYHOME/findPwPage.member">비밀번호찾기 찾기</a>
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</div> 




				<h1>홈페이지에오신걸 환영합니다</h1>
<!-- 정적인 페이지 포함 -->				
<%@ include file="/template/footer.jsp"%>