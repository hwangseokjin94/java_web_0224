package com.koreait.test;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 >> ");
		int age = sc.nextInt();
		
		String message = age >= 20 ? "성인" : "미성년자";
		System.out.println("당신은 " + age + "살이고, " + message + "이다.");
		
		sc.close();
		
		
		
		
		
		
	}

}
