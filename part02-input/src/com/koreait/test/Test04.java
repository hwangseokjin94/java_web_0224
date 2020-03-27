package com.koreait.test;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성별 입력(1~6) >> ");
		int genderNum = sc.nextInt();
		
		// String gender = genderNum == 1 || genderNum == 3 || genderNum == 5 ? "남자" : "여자";
		// genderNum 이 홀수이면 "남자"
		String gender = genderNum % 2 == 1 ? "남자" : "여자";

		System.out.println("성별은 " + gender + "이다.");
		
		sc.close();
		
	}

}
