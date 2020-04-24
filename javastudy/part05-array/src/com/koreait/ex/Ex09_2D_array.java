package com.koreait.ex;

import java.util.Arrays;

public class Ex09_2D_array {

	public static void main(String[] args) {
		
		int[][] arr2D = {
				{1, 2, 3},
				{4, 5},
				{6, 7, 8, 9}
		};
		
		
		// arr2D[0], arr2D[1], arr2D[2] 을 각각 1차원 배열로 생각하자.
		
		
		// 1. 일반 for 문 출력
		for (int i = 0; i < arr2D.length; i++) {
			for (int j = 0; j < arr2D[i].length; j++) {
				System.out.print(arr2D[i][j] + "\t");
			}
			System.out.println();
		}
		
		// 2. Arrays 클래스
		for (int i = 0; i < arr2D.length; i++) {
			System.out.println( Arrays.toString(arr2D[i]) );
		}
		
		// 3. 향상 for 문 (for each)
		for (int[] arr : arr2D) {
			for (int n : arr) {
				System.out.print(n + "\t");
			}
			System.out.println();
		}

	}

}
