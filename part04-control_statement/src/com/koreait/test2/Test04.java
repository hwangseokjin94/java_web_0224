package com.koreait.test2;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		//Test04.java
//		1부터 입력 받은 양수 사이의 모든 정수의 합계 출력하기
//		입력 받은 수가 2 이상이 아니면 다시 입력 받도록 처리
         /*  Scanner sc =new Scanner(System.in);
           int a = sc.nextInt();
           int sum=0;
           if(a<3) {
        	   System.out.println("다시");
        
            }else {
           for(int i =1;i<=a;i++){
        	   sum += i;
           }
       System.out.println(a+"까지수의 합은"+sum+"입니다.");
       }
       sc.close();
       */
	      Scanner sc =new Scanner(System.in);
	      int total = 0 ;//합계
	      int start =1;
	      int end = 0;
	      
	      do {
	      System.out.print("2이상의 양수입력>>>");
	      end =sc.nextInt();
	      }while(end<2);              //검사
	      
	      for(int n= start;n<end+1;n++) {
	    	 	  total += n;
	      }
	    	  
	      
	      
	      System.out.println(start+"~"+end+"모든 정수의 합"+total);
			
			sc.close();
       
	}

}
