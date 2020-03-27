package com.koreait.test2;

import java.util.Random;
import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();  // 난수를 발생할 수 있는 rand 객체 생성
		int answer = rand.nextInt(100) + 1;  // 발생한 난수
		int guess = 0;  // 사용자 입력 값
		int count = 0;  // 카운팅 변수
		
		do {
			System.out.print("1 ~ 100 사이 정수 입력 >> ");
			guess = sc.nextInt();
			count++;
			if (guess < answer) {
				System.out.println("Up!");
			} else if (guess > answer) {
				System.out.println("Down!");
			} else {
				System.out.println("Answer!");
				System.out.println("총 " + count + "회만에 성공.");
				break;
			}
		} while (answer != guess);
		
		sc.close();

	}

}