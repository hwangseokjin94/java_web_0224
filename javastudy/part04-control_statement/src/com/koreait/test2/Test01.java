package com.koreait.test2;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// 평점을 정수(1~5)로 입력받아 별(★, ★★, ★★★, ★★★★, ★★★★★) 출력하기
//		잘못된 평점이 입력되면 다시 입력 받고,
//		System.out.print("★")를 평점만큼 반복해서 사용할 것
		/*System.out.println("점수를입력하세요");
         Scanner sc =new Scanner(System.in);
         int a= sc.nextInt();
         if(a>5) {
        	 System.out.println("점수는 1~5입니다.");
         }
         
         for(a=0;a<5;a++) {
        	 
        	 System.out.print("★");	 
         }
         sc.close();
         */
		
		 Scanner sc =new Scanner(System.in);
         int grade=0;
         do {
        	 System.out.println("점수는 1~5입니다.");
        	 grade =sc.nextInt();
        	 
         }while (grade<1||grade>5);
         System.out.println("=============");
         for(int i =0;i<grade;i++) {
        	 
        	 System.out.print("★");	 
         }
         sc.close();
		
		
		
		
	}

}
