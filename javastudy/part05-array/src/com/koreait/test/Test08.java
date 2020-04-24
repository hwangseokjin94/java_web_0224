package com.koreait.test;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int STUDENTS = 2;
		final int SUBJECTS = 3;
		String[] name = {"철수", "미희", "합계"};
		String[] subject = {"국어", "영어", "수학", "총점"};
		int[][] score = new int[STUDENTS + 1][SUBJECTS + 1];
		
		// 1. 입력 및 계산
		// i : 학생의 번호
		// j : 과목의 번호
		for (int i = 0; i < STUDENTS; i++) {
			System.out.println(name[i] + " 성적 입력");
			for (int j = 0; j < SUBJECTS; j++) {
				System.out.print(subject[j] + " >> ");
				score[i][j] = sc.nextInt();
				score[i][SUBJECTS] += score[i][j];  // 학생의 총점
				score[STUDENTS][j] += score[i][j];  // 과목의 총점
				score[STUDENTS][SUBJECTS] += score[i][j];  // 전체 총점
			}
		}
		
		// 2. 출력
		System.out.print("\t");
		for (int i = 0; i < SUBJECTS + 1; i++) {
			System.out.print(subject[i] + "\t");
		}
		System.out.println();
		
		for (int i = 0; i < STUDENTS + 1; i++) {
			System.out.print(name[i] + "\t");
			for (int j = 0; j < SUBJECTS + 1; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
		
		sc.close();

	}

}
