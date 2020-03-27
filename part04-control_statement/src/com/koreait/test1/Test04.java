package com.koreait.test1;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		
		// A+
		// A : char grade;
		// + : char point;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수 입력 >> ");
		int score = sc.nextInt();
		
		char grade, point;
		if (score == 100) {
			grade = 'S';
			point = ' ';
		} else if (score < 70) {
			grade = 'F';
			point = ' ';
		} else {
			// grade
			if (score >= 90) {
				grade = 'A';
			} else if (score >= 80) {
				grade = 'B';
			} else {
				grade = 'C';
			}
			// point
			if (score % 10 >= 7) {
				point = '+';
			} else if (score % 10 >= 4) {
				point = '0';
			} else {
				point = '-';
			}
		}
		
		System.out.println("학점 = " + grade + point);
		
		sc.close();
		
	}

}
