package com.koreait.ex;

public class Ex10_operator2 {

	public static void main(String[] args) {
		
		/*
		 * 4. 관계 연산자
		 *    1) >= : 이상, 크거나 같다
		 *    2) >  : 초과, 크다
		 *    3) <= : 이하, 작거나 같다
		 *    4) <  : 미만, 작다
		 *    5) != : 같지 않다
		 *    6) == : 같다 (기본 자료형 : primitive type)
		 *       a.equals(b) : 같다 (참조 자료형 : reference type)
		 * 
		 * 5. 논리 연산자
		 *    1) && : 모든 조건식을 만족하면 true, 아니면 false
		 *    2) || : 조건식을 하나라도 만족하면 true, 아니면 false
		 *    3) !  : not 연산, 결과를 반대로 변경
		 *    4) short circuit evaluation 를 지원
		 *       - && : false 조건이 하나라도 나타나면 그 이후는 처리하지 않음
		 *       - || : true  조건이 하나라도 나타나면 그 이후는 처리하지 않음
		 * 
		 * 6. 조건 연산자
		 *    1) 조건식 ? 조건식이 true인 경우 : 조건식이 false인 경우
		 *    2) if ~ else 대용으로 널리 사용
		 */
		
		// 1. 관계/조건 연산자
		int a = 100;
		System.out.println(a == 100 && a > 10);  // true
		System.out.println(a == 100 || a < 10);  // true
		System.out.println(!(a == 100));  // false
		
		// 2. short circuit evaluation
		int b = 100;
		boolean c = (a == 10) && (++b > 10);
		System.out.println("a=" + a + ", b=" + b + ", c=" + c);
		boolean d = (a == 100) || (++b > 10);
		System.out.println("a=" + a + ", b=" + b + ", d=" + d);
		
		// 3. 조건 연산자
		// 1) 요금 : 성인은 4000원, 미성년자는 2000원
		int age = 18;
		// boolean isAdult = age >= 20 ? true : false;
		boolean isAdult = age >= 20;  // 위와 같은 코드
		int fee = isAdult ? 4000 : 2000;
		System.out.println("요금=" + fee + "원");
		
		// 2) 아이디가 "admin"이면 "관리자", 아니면 "일반유저"
		String userId = "admin";
		// userId == "admin"  불가능합니다.
		System.out.println(userId.equals("admin") ? "관리자" : "일반유저");
	
	}

}
