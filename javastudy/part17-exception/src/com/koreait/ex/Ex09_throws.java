package com.koreait.ex;

import java.util.Scanner;

class Calculator {
	private int count;

	// 메서드
	public void calculator(String a, String b) throws NumberFormatException, ArithmeticException {// calculator 메소드를
																									// 호출하는 곳에서 try
																									// catch처리를 하라는
																									// 의미이다.
		count++;
		int n1 = Integer.parseInt(a);// NumberFormatException 발생가능.
		int n2 = Integer.parseInt(b);
		System.out.println(n1 + "+" + n2 + "=" + (n1 + n2));
		System.out.println(n1 + "-" + n2 + "=" + (n1 - n2));
		System.out.println(n1 + "*" + n2 + "=" + (n1 * n2));
		System.out.println(n1 + "/" + n2 + "=" + (n1 / n2));// ArithmetiException발생가능]
	}

	public void countInfo() {
		System.out.println("계산기 사용횟수 :" + count + "회");
	}
}

public class Ex09_throws {

	public static void main(String[] args) {
		// Calculator 클래스를 이용해 myCalculator 객체 생성
		Calculator myCalculator = new Calculator();

		// 정수입력(String 이용)
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 a 입력 >>>");
		String a = sc.next();
		System.out.print("정수 b 입력 >>>");
		String b = sc.next();
		try {
			myCalculator.calculator(a, b);
			myCalculator.countInfo();
		} catch (NumberFormatException e) {
		System.out.println("예외메시지" + e.getMessage());
			e.printStackTrace();
		}catch (ArithmeticException e) {
			System.out.println("예외메시지" + e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("예외메시지" + e.getMessage());
			e.printStackTrace();
		}
		sc.close();
	}

}
