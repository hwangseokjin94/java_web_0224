<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_dynamic() {
		var f = document.forms.myForm;
		if (f.column.value == 'EMPLOYEE_ID'){
			if( isNaN(f.query.value)){
				alert('EMPLOYEE_ID는 숫자입니다.');
				f.query.value='';
				f.query.focus();
				return false; //서브밋 취소
			}
		}
		return true;
	}
</script>
</head>
<body>
	전체직원검색 <input type="button" value="검색" onclick="location.href='/22_MYBATIS/empList.do'"/>
	<br/><br/><br/>
	부서검색
	<form action="/22_MYBATIS/deptList.do">
		<select style="height: 200px;" name="department_id" multiple>
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option value="40">40</option>
			<option value="50">50</option>
			<option value="60">60</option>
			<option value="70">70</option>
			<option value="80">80</option>
			<option value="90">90</option>
			<option value="100">100</option>
			<option value="110">110</option>			
		</select>
	<br>
	<input type="submit" value="검색"/> 
	</form>
	<br><br>
	동적검색
	<form name="myForm" action="/22_MYBATIS/dynamicList.do" onsubmit="return fn_dynamic()">
		검색옵션
		<select name = "column">
			<option value="EMPLOYEE_ID">사원ID</option>
			<option value="LAST_NAME">LAST_NAME</option>
		
		</select>	
		<input type="text" name="query"/>		
		<input type="submit"  value="검색"/>
	</form>
	
	
</body>
</html>
























