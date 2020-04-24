package com.koreait.test1;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Test04.java - if 문

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
		/*System.out.println("점수를 입력하세요");
		Scanner sc =new Scanner(System.in);
	
	      if(score==100) {
	    	  System.out.println("S ");
	      }else if(score>=97 && score<=99) {
	    	  System.out.println("A+");
	      }else if(score>=94 && score<=96) {
	    	  System.out.println("A0");
	      }else if(score>=90 && score<=93) {
	    	  System.out.println("A-");
	      }else if(score>=87 && score<=89) {
	    	  System.out.println("B+");
	      }else if(score>=84 && score<=86) {
	    	  System.out.println("B0");
	      }else if(score>=80 && score<=83) {
	    	  System.out.println("B-");
	      }else if(score>=77 && score<=79) {
	    	  System.out.println("C+");
	      }else if(score>=74 && score<=76) {
	    	  System.out.println("C0");
	      }else if(score>=70 && score<=73) {
	    	  System.out.println("C-");
	      }else {
	    	  System.out.println("F");
	      }
	      */
		System.out.println("점수입력>>");
		char grade, point;
		Scanner sc =new Scanner(System.in);
		int score =sc.nextInt();
	      
	      if(score==100) { //grade
	    	  grade='S';
	    	  point=' ';
	    	  
	      }else if(score<70) {
	    	  grade='F';
	    	  point=' ';
	    	  
	      }else {
	    	  if(score>=90) {
	    		  grade ='A';
	    	  }else if (score >=80) {
	    		  grade ='B';
	    	  }else {
	    		  grade='C';
	    	  }
	      }
	      //point
	      if(score%10 >=7) {
	    	  point = '+';
	      }else if(score%10>=4) {
	    	  point = '0';
	      }else {
	    	  point='-';
	      }
	      System.out.println("학점 = "+grade+point);
	      
	      
	      sc.close();
	}

}
