package com.koreait.test1;

import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("월 입력 >> ");
		int month = sc.nextInt();
		
		if (month < 1 || month > 12) {
			System.out.println("없는 월이다.");
			System.exit(0);  // 정상 종료
			System.exit(1);  // 비정상 종료(0 이외의 값 전달) 
		}
		
		int day = 0;
		switch (month) {
		case 2: day = 28; break;
		case 4: case 6: case 9: case 11: day = 30; break;
		default: day = 31;
		}
		
		System.out.println(month + "월은 " + day + "일까지 있습니다.");
		
		sc.close();

	}

}