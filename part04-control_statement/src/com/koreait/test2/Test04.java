package com.koreait.test2;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int total = 0;  // 합계
		int start = 1;
		int end = 0;
		
		do {
			System.out.print("2 이상의 양수 입력 >> ");
			end = sc.nextInt();
		} while (end < 2);
		
		for (int n = start; n < end + 1; n++) {
			total += n;
		}
		
		System.out.println(start + " ~ " + end + " 사이 모든 정수의 합 = " + total);
		
		sc.close();

	}

}
