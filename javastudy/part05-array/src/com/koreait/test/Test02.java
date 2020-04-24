package com.koreait.test;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int total = 0;
		
		for (int i = 0; i < arr.length; i++) {
			// 1. 입력
			System.out.print((i + 1) + "번째 입력 >> ");
			arr[i] = sc.nextInt();
			// 2. 누적
			total += arr[i];
		}
		
		System.out.println("총 합은 " + total + "이다.");
		
		sc.close();

	}

}
