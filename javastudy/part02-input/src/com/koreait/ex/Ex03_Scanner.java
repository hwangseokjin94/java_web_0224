package com.koreait.ex;

import java.util.Scanner;

public class Ex03_Scanner {

	public static void main(String[] args) {
		
		//  \n : 줄바꿈 (엔터)
		
		// 1) Scanner 클래스의 scanner 객체 생성
		Scanner scanner = new Scanner(System.in);
		
		
		// nextInt(), nextDouble() : 숫자 뒤 \n 을 통해 숫자로 인식
		
		
		// 2) 입력
		System.out.print("나이 입력 >> ");  // 20\n
		int age = scanner.nextInt();  // age=20, \n은 남겨둠
		
		System.out.print("키 입력 >> ");  // \n180.5\n
		double height = scanner.nextDouble();  // height=180.5, \n은 남겨둠
		
		System.out.print("성명 입력 >> ");  // \n홍 길동\n
		String name = scanner.nextLine();  // name=\n, 홍 길동\n은 남겨둠
		
		System.out.print("성별 입력 >> ");
		char gender = scanner.next().charAt(0);
		
		
		// 3) 출력
		System.out.println("성명=" + name);
		System.out.println("나이=" + age);
		System.out.println("키=" + height);
		System.out.println("성별=" + gender);
		
		// 4) scanner 객체 소멸
		scanner.close();  // 생략 가능(생략하면 JVM이 스스로 닫음)
		
	}

}
