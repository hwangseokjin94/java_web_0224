package com.koreait.test2;

public class Test03 {

	public static void main(String[] args) {
		// 
//		Test03.java
//		1 ~ 100 사이의 모든 정수 중에서 일의자리가 3의 배수인 정수들의 합계 출력하기

	      
	      int total = 0 ;//합계
	      int start =1;
	      int end = 100;
	      int unitsDigit=0;//1의자리
	      for(int n= start;n<end+1;n++) {
	    	  //1의자리 추출
	    	  unitsDigit=n%10;
	    	  if(unitsDigit%3==0 && unitsDigit !=0) {
	    		  total += n;
	    	  }
	    	  
	      }
	      
	      System.out.println(start+"~"+end+"사이일의자리가 3의배수인 정수의 합"+total);
			
		
	}

}
