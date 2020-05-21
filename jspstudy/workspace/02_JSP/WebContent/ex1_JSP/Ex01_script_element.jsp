<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>if 문</h3>
	<%  int a= 10;%>
	<% 	if(  true ){%>
		<%=a%>	 <!-- 변수출력은 표현식으로한다 -->
	<%}%>

	<h3>1~10사이 모든 정수 출력</h3>
	
<% 	int b =0;
	for(int i = 0 ; i<10 ;i++){
		b++;%><%-- 변수 출력은 표현식으로 한다. --%>
			<%=b%>
<%	}%>
	<h3>1~10사이 모든정수를 sum함수</h3>
	<%! 
	  public int sum(){
		int total =0;
		for(int i=1;i<11;i++){
			total += i;
		}
		return total;
	}
	%>
	<div> 1~10 합:  <%=sum()%>
	</div>

	<h3>1~10 사이 모든 짝수 합계 리턴없이 구하는 even()</h3>
	
	<%!
		int total = 0;
		public void even(){ 
			for(int i = 1 ; i <11; i++){
				if(i%2 == 0){
				total +=i;
				}		
			}
		}
	%>
	
	
	<div>
	<% even();//even 메소드호출 %>
	 1~10  짝수 합:  <%=total%>
	</div>
	
	
	
</body>
</html>