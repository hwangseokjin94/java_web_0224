<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
	//jquery 의 onload
	//$(document).ready(function(){});
	//$(function(){});
	$(function () {
		
		//텍스트 가져오기
		$('#btn1').click(function name() {
			$.ajax({
				url:'textHandler', //RequestMappin값 
				type: 'GET',
				data:'sender='+$('#sender').val(), //Controller에게 전달하는 파라미터
				dataType:'text', //controller에게 받아오는 데이터( responseText) 의타입
				success: function( responseText ) {
					$('#content1').text(responseText);
				},
				error: function () {
					alert('AJAX통신 실패');
				}
			});
		});
		
		
		//JSON가저오기
		$('#btn2').click(function name() {
			$.ajax({
				url:'jsonHandler', //RequestMappin값 
				type: 'GET',
				data:'sender='+$('#sender').val(), //Controller에게 전달하는 파라미터
				dataType:'json', //controller에게 받아오는 데이터( responseText) 의타입
				success: function( responseObj ) {
					$('#content2').text(responseObj.sender+','+responseObj['receiver']);
				},
				error: function () {
					alert('AJAX통신 실패');
				}
			});
		});
				
	
		
	});
</script>
</head>
<body>
	<form>
	<h1> AJAX통신 </h1>
	
		보내는 사람 <input type="text" id="sender" name="sender"/><br/>	
		<input id="btn1" type="button" value="텍스트가저오기"/><br/>
		<div id="content1"></div>
		
		<input id="btn2" type="button" value="JSON가져오기"/><br/>
		<div id="content2"></div>
		
	</form>
</body>
</html>