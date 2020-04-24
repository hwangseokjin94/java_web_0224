
package com.koreait.ex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03_multi_catch {
	public static void main(String[] args) {
		try {
			// 코드 작성
			Scanner sc = new Scanner(System.in);
			System.out.print("a 입력 >>");
			int a = sc.nextInt();

			System.out.print("b 입력 >>");
			int b = sc.nextInt();

			System.out.println(a + "+" + b + "=" + (a + b));
			System.out.println(a + "-" + b + "=" + (a - b));
			System.out.println(a + "*" + b + "=" + (a * b));
			System.out.println(a + "/" + b + "=" + (a / b));

			sc.close();
		} catch (InputMismatchException e) {
			System.out.println("입력은 정수타입만 가능합니다.");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌수없습니다.");
		} catch (Exception e) {// 모든 예외를 처리할수있는 catch (Exception e) 마지막에 기입해야된다 
			System.out.println("문제가 발생하여 처리할수 없습니다.");
	
		}
	}
}