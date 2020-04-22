package com.koreait.etc;

/*1.primitive type -> reference type 변경해 주는 클래스들을 의미한다.
 *2.종류
 * 1)byte  ->Byte 
 * 2)int   ->Integer
 * 3)char  -> Character
 * 4)short ->Short
 * 5)long ->Long
 * 6)double - >Double
 * 
 * 3. 변수를 "객체(인스턴스)"로 변환해주는 클래스들이다.
 * 4. 자동으로 변환되는 "Auto Boxing , UnBoxing을 지원한다.
 * 5.반드시 reference type을 요구하는 클래스 및 메소드가 있다. 그럴떄 사용한다.
 * 
 * 
 * 모두의부모 Object
 * **/
public class Ex03_wrapper_class {

	public static void main(String[] args) {
		Integer a = new Integer(10);
		Integer b = new Integer("10");

		// 동등비교
		System.out.println("a와 b의 참조 (주소,위치)비교 : " + (a == b));
		System.out.println("a와 b의 값을 비교 :" + a.equals(b));

		// 크기비교
		// a.compareTo(b) : 결과는 a-b계산을 통해서 결정
		// a-b: 결과 1
		// a<b:결과 -1
		// a==b : 결과 0
		System.out.println("a와 b의 크기 비교 : " + a.compareTo(b));

		// Auto Boxing

		Integer c = 100;
		Integer d = 200;

		//Auto UnBoxing (Integer - > int)
		int result = c+d;
		System.out.println(result);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
