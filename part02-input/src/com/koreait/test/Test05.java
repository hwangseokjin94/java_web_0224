package com.koreait.test;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 >> ");
		int kor = sc.nextInt();
		System.out.print("영어 점수 >> ");
		int eng = sc.nextInt();
		System.out.print("수학 점수 >> ");
		int mat = sc.nextInt();

		double average = (kor + eng + mat) / 3.0;
		
		char grade = average >= 90 ? 'A' : average >= 80 ? 'B' : average >= 70 ? 'C' : average >= 60 ? 'D' : 'F';
		
		System.out.println("평균은 " + average + "점, 학점은 " + grade + "학점이다.");
		System.out.printf("평균은 %10.2f점, 학점은 %c학점이다.%n", average, grade);
		
		sc.close();
		
	}

}
