<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int age = Integer.parseInt(request.getParameter("age"));

	// forward
	// 기존의 request 를 그대로 다시 사용한다.

	if ( age >= 20 ) {
		request.getRequestDispatcher("/ex3_quiz/Q02_adult.jsp").forward(request, response);
	} else {
		request.getRequestDispatcher("/ex3_quiz/Q02_child.jsp").forward(request, response);
	}
%>