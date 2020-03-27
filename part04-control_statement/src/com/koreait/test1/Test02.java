package com.koreait.test1;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("필기 점수 입력 >> ");
		int theory = sc.nextInt();
		System.out.print("실기 점수 입력 >> ");
		int practice = sc.nextInt();
		
		/*
		double average = (theory + practice) / 2.0;  // 필기와 실기가 모두 70 이상이면 굳이 안 구해도 되는데...
		
		if ( (theory >= 70 && practice >= 70) || average >= 80 ) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		*/
		
		// || : or 연산자는 true 인 조건식이 나타나면 그 이후는 처리하지 않는다.
		// 필기와 실기가 모두 70 이상이면 평균을 구하지 않는다.
		if ( (theory >= 70 && practice >= 70) || (theory + practice) / 2.0 >= 80 ) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
		
		sc.close();
		
	}

}
