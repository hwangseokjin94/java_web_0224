package com.koreait.test;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("매출액 입력 >> ");
		int salesMoney = sc.nextInt();
		System.out.print("등급 입력 >> ");
		String grade = sc.next();
		
		// 100% : 1
		// 10% : 0.1
		// 1% : 0.01

		
		// 라인 위치 조정 : Alt + 방향키(↑, ↓) 
		
		
		// equals() 메소드는 대소문자를 구분해서 비교한다.
		// double earn = grade.equals("VIP") ? salesMoney * (1 - 0.2) : salesMoney * (1 - 0.05);
		
		// equalsIgnoreCase() 메소드는 대소문자를 구분하지 않는다.
		double earn = grade.equalsIgnoreCase("VIP") ? salesMoney * (1 - 0.2) : salesMoney * (1 - 0.05);
		
		// 아래 식은 / 가 나누기가 아닌 몫을 구하는 연산자이므로 사용할 수 없다.
		// double earn = grade.equalsIgnoreCase("VIP") ? salesMoney / 100 * 80 : salesMoney / 100 * 95;
		
		System.out.println("실제 매출=" + (int)earn + "원");
		
		sc.close();
		
	}

}
