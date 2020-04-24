package com.koreait.test2;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		/*
		* 두 정수를 입력 받아 두 정수 사이의 모든 정수의 합계 출력하기
		입력 순서와 무관하게 동일한 결과를 출력
		실행 예1)
		   첫 번째 정수 >> 1
		   두 번째 정수 >> 10
		   1부터 10까지 모든 정수의 합은 55입니다.
		실행 예2)
		   첫 번째 정수 >> 10
		   두 번째 정수 >> 1
		   1부터 10까지 모든 정수의 합은 55입니다.
		*/
       /* Scanner sc =new Scanner(System.in);
        int num1,num2;
        
        int sum=0;
        System.out.println("첫번쨰정수를 입력하세요");
        num1 =sc.nextInt();
        System.out.println("두번쨰정수를 입력하세요");
        num2 =sc.nextInt();
        for(int i=num1;num1<=num2;num1++) {
        	
        	sum+=num1;
        }

        System.out.println(num1+"부터"+ num2+"까지 모든 정수의 합은"+sum+"입니다.");
        
        sc.close();
        */
		  Scanner sc =new Scanner(System.in);
	      int total = 0 ;//합계
	      int start =0;
	      int end = 0;
	      
	      System.out.print("첫번쨰정수입력>>>");
	      start =sc.nextInt();
	      System.out.print("두번쨰정수입력>>>");
	      end =sc.nextInt();
	      //start>end 경우 이 두값을 교환
	      int temp =start;
	      
	      if(start>end) {
	    	temp=start;
	    	start =end;
	    	end=temp;
	    	  
	      }
	      
	      for(int n= start;n<end+1;n++) {
	    	 	  total += n;
	      }
	    	  
	      
	      
	      System.out.println(start+"~"+end+"모든 정수의 합"+total);
			
			sc.close();
	}

}
