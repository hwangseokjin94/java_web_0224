/**
 * 
 */

	//문제. 반올림 ,올림 ,내림 함수처리
	//1)반올림: point(123.456,2) = 123.46
	//2)올림 :pointUp(123.456,2) =123.46
	//3)올림 :pointDown(123.456,2) =123.45
	
	//소수2자리
	//소수1자리
	//정수
	//일의자리
	//십으자리
	function point(num , n){
		return Math.round(num*Math.pow(10, n)) / Math.pow(10, n);
	}
	function pointUp(num , n){
		return Math.round(num*Math.pow(10, n)) / Math.pow(10, n);
	}
	function pointDown(num , n){
		return Math.round(num*Math.pow(10, n)) / Math.pow(10, n);
	}
	console.log(point(123.456,2));
	
	
	
	
	function point(number, digit) {
		return Math.round(number * Math.pow(10, digit)) / Math.pow(10, digit);
	}
	function pointUp(number, digit) {
		return Math.ceil(number * Math.pow(10, digit)) / Math.pow(10, digit);
	}
	function pointDown(number, digit) {
		return Math.floor(number * Math.pow(10, digit)) / Math.pow(10, digit);
	}
	
	// 문제. 정수를 정해진 자리수로 맞춰서 사용하기
	// fillZero(number, 2) = 00, 01, 02, ...
	// fillZero(number, 3) = 000, 001, 002, ...
	
	
	function fillZero(number,digit){
		var result = String(number);
		while(result.length!= digit){
			result = '0'+result;
		}
		return result;
	}
	
	
	
	
	// Ex20_함수문제. 날짜와 시간을 다음과 같은 형식으로 변경하여 리턴하는 to12Times 함수
	// 2020-05-08 금요일 오전 11:30

	function to12Times(date) {
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var weekname = ['일', '월', '화', '수', '목', '금', '토'][date.getDay()];
		var hour = date.getHours();
		var ampm = hour < 12 ? '오전' : '오후';
		var minute = date.getMinutes();
		return year + '-' +
			   fillZero(month, 2) + '-' +
			   fillZero(day, 2) + ' ' +
			   weekname + '요일 ' +
			   ampm + ' ' + hour + ':' + minute;
		
		
	}

	
		 
		
	function watch() {
		setTimeout(function () {
		var date  = new Date();
		var year = date.getFullYear();
		var month = date.getMonth() + 1;
		var day = date.getDate();
		var weekname = ['일', '월', '화', '수', '목', '금', '토'][date.getDay()];
		var hour = date.getHours();
		var ampm = hour < 12 ? '오전' : '오후';
		var minute = date.getMinutes();
	    var second =date.getSeconds()
		var result =year + '-' +
			   fillZero(month, 2) + '-' +
			   fillZero(day, 2) + ' ' +
			   weekname + '요일 ' +
			   ampm + ' ' + hour + ':' +  fillZero(minute,2)+'분'+
			   fillZero(second,2)+'초입니다';
		 document.getElementById('clock').innerHTML=result;
		 watch();
		}, 1000); 
	}		
	

	function countDown(){
		setTimeout(function (){
			var d_day = new Date(2020,11,3);
			var today = new Date();
			
			var restTime = d_day.getTime() -today.getTime(); //d데이 밀리초 -현재밀리초
			restTime = parseInt(restTime/1000); //남은시간 (초)
			//d데이종료
			if(restTime <= 0){
				document.getElementById('d-day').innerHTML = 'D-day이다';
				return;
			}
			//남은시간 ->일 ,시, 분,초,
			var second= restTime%60;
			var minute = parseInt(restTime / 60) % 60;
			var hour = parseInt(restTime / 3600 ) % 24;
			var day = parseInt (restTime / 3600 /24) ;
			
			//결과
			var result = '';
			if(day !=0){
				result += day+'일'
			}
			result +=hour+'시'+minute+'분'+second+'초남음';			
			document.getElementById('d-day').innerHTML = result;
			
			//1일 이내에는 빨간색으로표시
			if(day == 0){
				document.getElementById('d-day').style.color='red';
			}
			
			//다시호출
			countDown();
			
			
		},1000);
	}
	
	
	