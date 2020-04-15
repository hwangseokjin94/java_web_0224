package com.koreait.test1;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
//		Test02.java
//		필기와 실기 점수를 입력 받아 합격 유무 출력하기
//		필기와 실기 점수가 모두 70 이상이거나, 평균이 80 이상이면 "합격" 아니면 "불합격"

		Scanner sc =new Scanner(System.in);
		System.out.println("필기점수를 입력하세요");
		int score1 = sc.nextInt();
		System.out.println("실기점수를 입력하세요");
		int score2 = sc.nextInt();
		/*
		double avg = (score1+score2)/2.0;//필기와 실기가 모두 70이상이면 굳이안구해도됨...
		
		if((score1>=70 && score2>=70)||avg>=80) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
			}
		*/
		
		// ||: or연산자 true인 조건식이 나타나면 그이후는 처리하지 않는다.
		//필기와 실기가 모두 70이상이면 평균을 구하지않는다.
		if((score1>=70 && score2>=70)||(score1+score2)/2.0>=80) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
			}
		
		sc.close();
	}

}
