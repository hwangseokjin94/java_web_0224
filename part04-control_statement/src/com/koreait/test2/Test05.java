package com.koreait.test2;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int total = 0;  // 합계
		int start = 0;
		int end = 0;
		
		System.out.print("첫 번째 정수 입력 >> ");
		start = sc.nextInt();
		System.out.print("두 번째 정수 입력 >> ");
		end = sc.nextInt();
		
		// start > end 경우 이 두 값을 교환
		if (start > end) {
			int tmp = start;
			start = end;
			end = tmp;
		}
		
		for (int n = start; n < end + 1; n++) {
			total += n;
		}
		
		System.out.println(start + " ~ " + end + " 사이 모든 정수의 합 = " + total);
		
		sc.close();

	}

}