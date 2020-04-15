package com.koreait.test1;

import java.util.Scanner;

public class Test01 {
	
//	Test01.java
//	정수를 입력 받아 "짝수", "홀수"를 구분해서 출력하기
//	단, 3의 배수는 "3의 배수"로 출력하기

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	

	Scanner sc = new Scanner(System.in);
	int a=0;
	a= sc.nextInt(); 
	
	if((a%2)==0) {
		System.out.println("짝수입니다");
	}else if((a%2)!=0) {
		System.out.println("홀수입니다");
	
	}
	sc.close();
}
	
}