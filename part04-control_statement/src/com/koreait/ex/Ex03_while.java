package com.koreait.ex;

import java.util.Scanner;

public class Ex03_while {

	public static void main(String[] args) {
		
		// 1. 0 ~ 9 출력
		int a = 0;  // 초기문
		while (a < 10) {  // 조건문(종료문)
			System.out.println(a);
			a++;  // 증감문
		}
		
		// 2. 9 ~ 0 출력
		int b = 9;
		while (b > -1) {
			System.out.println(b);
			b--;
		}
		
		// 3. 'A' ~ 'Z' 출력
		char ch = 'A';
		while (ch <= 'Z') {
			System.out.println(ch);
			ch++;
		}
		
		// 4. "admin" 아이디가 입력될때까지 계속 입력받기
		// 몇 번만에 입력되었는지 출력
		Scanner sc = new Scanner(System.in);
		
		// String userId = null;
		String userId = "";
		int count = 0;  // 카운팅 변수 초기화 0
		
		while ( !userId.equals("admin") ) {
			System.out.print("아이디 입력 >> ");
			userId = sc.next();
			count++;
		}
		
		System.out.println("admin은 " + count + "번만에 입력됨.");
		
		sc.close();
		
	}

}
