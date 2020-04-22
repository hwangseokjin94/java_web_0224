package com.koreait.test;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("섭씨 입력 >> ");
		double celsius = sc.nextDouble();
		
		double fahrenheit = celsius * 1.8 + 32;
		
		System.out.println("입력된 섭씨 " + celsius + "는 화씨 " + fahrenheit + "이다.");

		sc.close();
		
	}

}
