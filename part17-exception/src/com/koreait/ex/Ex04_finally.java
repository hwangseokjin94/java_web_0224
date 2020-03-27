package com.koreait.ex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex04_finally {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			// 코드 작성
			System.out.print("a 입력 >>");
			int a = sc.nextInt();

			System.out.print("b 입력 >>");
			int b = sc.nextInt();

			System.out.println(a + "+" + b + "=" + (a + b));
			System.out.println(a + "-" + b + "=" + (a - b));
			System.out.println(a + "*" + b + "=" + (a * b));
			System.out.println(a + "/" + b + "=" + (a / b));

//			sc.close(); //예외가 발생하면 sc를 닫을수가 없다.  (물론 , 자바가스스로닫지만)
		} catch (InputMismatchException e) {
			System.out.println("입력은 정수타입만 가능합니다.");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌수없습니다.");
		} catch (Exception e) {// 모든 예외를 처리할수있는 catch (Exception e) 마지막에 기입해야된다
			System.out.println("문제가 발생하여 처리할수 없습니다.");
		} finally {
			if (sc != null) {
				sc.close(); // 정상종료 예외발생후 종료 모두처리할수있다.
			}

		}

	}
}