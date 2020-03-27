package com.koreait.test2;

public class Test08 {

	public static void main(String[] args) {
		
		boolean condition1 = false;  // 일의 자리가 3의 배수인가?
		boolean condition2 = false;  // 십의 자리가 3의 배수인가?
		
		for (int n = 1; n < 100; n++) {
			condition1 = (n % 10) % 3 == 0 && (n % 10) != 0;
			condition2 = (n / 10) % 3 == 0 && (n / 10) != 0;
			if (condition1 && condition2) {
				System.out.print("짝짝\t");
			} else if (condition1 || condition2) {
				System.out.print("짝\t");
			} else {
				System.out.print(n + "\t");
			}
			// 10, 20, ... : 10의 배수 출력 후에는 줄 바꿈
			if (n % 10 == 0) {
				System.out.println();
			}
		}

	}

}
