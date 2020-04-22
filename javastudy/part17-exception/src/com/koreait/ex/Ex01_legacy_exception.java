package com.koreait.ex;

import java.util.Scanner;

public class Ex01_legacy_exception {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("a 입력 >>");
		int a = sc.nextInt();
		
		System.out.print("b 입력 >>");
		int b = sc.nextInt();
		
		//사칙연산과
		//어떤예외(문제)가 가능할지 예상해보자
		//0으로 나누는작없은 없다.
		if(b == 0 ) {
			System.out.println("0으로 나눌수없다. ");
		}else {
			System.out.println(a+"+"+b+"="+(a+b));
			System.out.println(a+"-"+b+"="+(a-b));
			System.out.println(a+"*"+b+"="+(a*b));
			System.out.println(a+"/"+b+"="+((double)a/b));
		}
		
		//고전적인 예외 처리방법 :if
		//개발자가 이미 어떤 문제가 발생할것인지 예측 가능해야만 코드를 작성할수있다.
		//개발자가 예상 못하는 예외는 처리가 불가능하다.
		
		

		sc.close();
	}
}
