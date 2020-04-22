package com.koreait.test;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int a, b, temp;
		
		System.out.print("a 입력 >> ");
		a = scanner.nextInt();
		System.out.print("b 입력 >> ");
		b = scanner.nextInt();
		
		temp = a;
		a = b;
		b = temp;
		
		System.out.println("a : " + a + ", b : " + b);
		
		scanner.close();
		
	}

}
