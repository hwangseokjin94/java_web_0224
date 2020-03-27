package com.koreait.test1;

import java.util.Scanner;

public class Test09 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수준 입력 >> ");
		int power = sc.nextInt();
		
		// 1.
		switch (power) {
		case 3:
			System.out.println("실행, 쓰기, 읽기");
			break;
		case 2:
			System.out.println("쓰기, 읽기");
			break;
		case 1:
			System.out.println("읽기");
			break;
		default:
			System.out.println("권한이 없습니다.");
		}
		
		
		// 2. 
		switch (power) {
		case 3: System.out.print("실행, ");  // break; 문을 만날때까지 모두 실행
		case 2: System.out.print("쓰기, ");
		case 1: System.out.println("읽기");
			break;
		default:
			System.out.println("권한이 없습니다.");
		}
		
		sc.close();

	}

}