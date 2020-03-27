package com.koreait.ex;

import java.util.Scanner;

public class Ex07_2D_array {

	public static void main(String[] args) {
		
		/*
		 * 고정형 2차원 배열
		 *  1. 행과 열이 고정된 2차원 배열
		 *  2. 선언 방법
		 *     int[][] arr = new int[3][2];  // 3행 2열
		 *  3. 초기화 방법
		 *     1) int[][] arr = new int[][] { {1, 2}, {3, 4}, {5, 6} };
		 *     2) int[][] arr = { {1, 2}, {3, 4}, {5, 6} };  // 추천
		 */
		
		int[][] arr = { 
				{1, 2}, 
				{3, 4}, 
				{5, 6} 
			};
		
		System.out.println("arr의 행 수 = " + arr.length);
		System.out.println("arr[0]의 열 수 = " + arr[0].length);
		System.out.println("arr[1]의 열 수 = " + arr[1].length);
		System.out.println("arr[2]의 열 수 = " + arr[2].length);
		
		// 행 인덱스 : i
		// 열 인덱스 : j
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}  // end for j
			System.out.println();
		}  // end for i
		
		
		// 2행 3열 배열을 생성하고,
		// 사용자로부터 데이터를 입력 받아 저장하고 출력하기
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[2][3];
		
		// 1. 입력
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print("a[" + i + "][" + j + "] >> ");
				a[i][j] = sc.nextInt();
			}
		}
		
		// 2. 출력
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		sc.close();
		
		
		
		
		
		
	}

}
