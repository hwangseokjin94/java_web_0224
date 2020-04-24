package com.koreait.ex;

// import java.util.Random;
import java.util.*;  // java.util 패키지의 모든 클래스를 사용할 수 있다.

public class Ex01_Random {

	public static void main(String[] args) {
		
		// 1. Random 클래스를 이용해 random 객체 생성
		Random random = new Random();

		System.out.println(random.nextInt());  // int 데이터 범위 중 하나의 난수가 출력
		System.out.println(random.nextInt(10));  // 10개(0 ~ 9) 정수 중 하나의 난수를 발생시켜 출력
		
		// 주사위 던지기
		int dice = random.nextInt(6) + 1;  // 6개 정수, 시작은 1
		System.out.println("주사위 던지기 = " + dice);
		
		
		
		System.out.println(random.nextDouble());  // 0 ~ 0.999999
		System.out.println(random.nextDouble() * 10);  // 0 ~ 9.999999
		System.out.println(   (int)(random.nextDouble() * 10)   );  // 0 ~ 9
		
		
		// 로또 번호 중 하나를 난수로 발생
		int lotto = (int)(random.nextDouble() * 45) + 1;
		System.out.println("생성된 로또 번호 = " + lotto);
		
		
	}

}
