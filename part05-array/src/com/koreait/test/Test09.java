package com.koreait.test;

public class Test09 {

	public static void main(String[] args) {

		final int SIZE = 5;
		int[][] bingo = new int[SIZE][SIZE];
		
		// 1. 1 ~ 25 순차 저장
		int n = 1;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				bingo[i][j] = n++;
				bingo[i][j] = i * SIZE + 1 + j;
			}
		}
		
		// 2. 섞기 (SHUFFLE)
		// x 방향 : 0 ~ SIZE - 1
		// y 방향 : 0 ~ SIZE - 1
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				int randX = (int)(Math.random() * SIZE);
				int randY = (int)(Math.random() * SIZE);
				int tmp = bingo[i][j];
				bingo[i][j] = bingo[randX][randY];
				bingo[randX][randY] = tmp;
			}
		}
		
		// 3. 출력
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.printf("%4d", bingo[i][j]);
			}
			System.out.println();
		}
		
	}

}
