package com.koreait.test;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[5];
		String[] names = {"강호동", "신동엽", "김용만", "유재석", "남희석"};
		
		// 1. 5개 점수 입력
		for (int i = 0; i < scores.length; i++) {
			System.out.print(names[i] + "의 점수 입력 >> ");
			scores[i] = sc.nextInt();
		}
		
		// 2. 최대, 최소, 합계(평균을 위해서) 초기화
		// 배열의 첫 번째 요소 값을 초기화로 사용
		int max = scores[0];
		int min = scores[0];
		int total = scores[0];
		String maxName = "강호동";
		String minName = "강호동";
		int maxNo = 0;
		int minNo = 0;
		
		// 3. 최대, 최소, 합계 계산
		// 두 번째 요소부터 사용할 것 (이미 첫 번째 요소는 사용했기 때문)
		for (int i = 1; i < scores.length; i++) {
			// 1) 최대
			if (max <= scores[i]) {
				max = scores[i];
				maxName = names[i];
				maxNo = i;
			}
			// 2) 최소
			if (min >= scores[i]) {
				min = scores[i];
				minName = names[i];
				minNo = i;
			}
			// 3) 합계
			total += scores[i];
		}
		
		// 4. 출력
		System.out.println("최대(" + maxName + ") : " + max + "점");
		System.out.println("최대(" + names[maxNo] + ") : " + max + "점");
		System.out.println("최소(" + minName + ") : " + min + "점");
		System.out.println("최소(" + names[minNo] + ") : " + min + "점");
		System.out.println("평균 : " + ((double)total / scores.length));
		
		sc.close();

	}

}
