package main.parameter;

import java.util.InputMismatchException;

public class Calculator {
	public static void main(String[] args) {
		//main 메소드에 파라미터 전달하는 방법
		//Run - Run Configuration - Arguments탭 - Program Arguments
		//각 파라미터를 공백 문자로 구분하여 입력
		
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			System.out.println(a + "+" +b+"="+(a+b));
			System.out.println(a + "-" +b+"="+(a-b));
			System.out.println(a + "*" +b+"="+(a*b));
			System.out.println(a + "/" +b+"="+(a/b));
		}catch(ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Run - Run Configuration 메뉴를 통해 파라미터를 2개 전달해야한다");
			
		}catch (ArithmeticException e) {
			System.out.println("0으로 나눌수없습니다.");
		}catch (NumberFormatException e) {
			System.out.println("정수를 입력해야합니다.");
		}catch (Exception e) {
			System.out.println("알수없는 오류입니다.");
		}
	}
}
