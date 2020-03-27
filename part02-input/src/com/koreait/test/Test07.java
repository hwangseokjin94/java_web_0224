package com.koreait.test;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 주민등록번호를 정수로 입력받는 경우
		System.out.print("주민등록번호 입력 >> ");
		long sn = sc.nextLong();  // 9999991999999 => 9999991 => 1
		long genderNum = sn / 1000000 % 10;
		
		String gender = genderNum % 2 == 1 ? "남자" : "여자";
		System.out.println("성별은 " + gender + "이다.");
		
		// 2. 주민등록번호를 문자열로 입력받는 경우
		System.out.print("주민등록번호 입력 >> ");
		String strSn = sc.next();
		
		char genderNum2 = strSn.charAt(6);  // 7번째 글자를 사용함
		
		String gender2 = genderNum2 % 2 == 1 ? "남자" : "여자";
		System.out.println("성별은 " + gender2 + "이다.");
		
		sc.close();
		
	}

}
