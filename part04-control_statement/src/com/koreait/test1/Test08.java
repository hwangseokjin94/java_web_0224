package com.koreait.test1;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력할 온도의 종류를 선택하세요(섭씨 또는 화씨) >> ");
		String choice = sc.next();
		
		switch (choice) {
		case "섭씨":
			System.out.print("섭씨 입력 >> ");
			double celsius = sc.nextDouble();
			double fahrenheit = celsius * 1.8 + 32;
			System.out.println("변환된 화씨는 " + fahrenheit + "입니다.");
			break;
		case "화씨":
			System.out.println("화씨 입력 >> ");
			fahrenheit = sc.nextDouble();
			celsius = (fahrenheit - 32) / 1.8;
			System.out.println("변환된 섭씨는 " + celsius + "입니다.");
			break;
		default:
			System.out.println("섭씨 또는 화씨만 입력 가능합니다.");
		}
		
		sc.close();

	}

}



