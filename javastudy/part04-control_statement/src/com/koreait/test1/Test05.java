package com.koreait.test1;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
//		Test05.java - switch 문

//		하나의 점수를 입력 받아 해당 학점 출력하기
//		100 : S
//		 99 ~ 97 : A+
//		 96 ~ 94 : A0
//		 93 ~ 90 : A-
//		 89 ~ 87 : B+
//		 86 ~ 84 : B0
//		 83 ~ 80 : B-
//		 79 ~ 77 : C+
//		 76 ~ 74 : C0
//		 73 ~ 70 : C-
//		 69 ~ 0 : F
	/*
		System.out.println("점수를 입력하세요");
		Scanner sc =new Scanner(System.in);
		int score = sc.nextInt();
	
		switch(score/10) {
		case 10 :
			System.out.print("S");break;
		case 9 :
			System.out.print("A");break;
		case 8 :
			System.out.print("B");break;
		case 7 :
			System.out.print("C");break;
		case 6 :case 5 :case 4 :case 3 :case 2 :case 1 :
			System.out.print("F");break;
		
		}
		
		switch(score%10) {
		case 7 : case 8 : case 9 :
			System.out.print("+");break;
		case 6 : case 5 : case 4 :
			System.out.print("0");break;
		case 3 : case 2 : case 1 :case 0 :
			System.out.print("-");break;
	
		
		}
		
		*/
		
		System.out.println("점수를 입력하세요");
		Scanner sc =new Scanner(System.in);
		int score = sc.nextInt();
	    char point = 0 ,grade;
		//point
		switch(score%10) {
		case 7 : case 8 : case 9 :
			point = '+';  break;
		case 6 : case 5 : case 4 :
			point = '0';  break;
		case 3 : case 2 : case 1 :case 0 :
			point = '-';  break;
		}
		
		switch(score/10) {
		case 10 :
			grade = 'S';   point =' '; break;
		case 9 :
			grade = 'A';break;
		case 8 :
			grade = 'B';break;
		case 7 :
			grade = 'C';break;
		default : 
			grade = 'F'; point =' '; break;
			
		}
	      
	    System.out.println("학점 = " + grade + point);
	      
	   sc.close();   
	     
	}

}
