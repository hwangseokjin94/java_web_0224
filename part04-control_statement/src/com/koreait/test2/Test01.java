package com.koreait.test2;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int grade = 0;
		
		do {
			System.out.print("평점(1~5) 입력 >> ");
			grade = sc.nextInt();
		} while (grade < 1 || grade > 5);
		
		System.out.println("-----");
		
		for (int i = 0; i < grade; i++) {  // grade 만큼 반복
			System.out.print("★");
		}
		
		sc.close();

	}

}
