package com.koreait.ex;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex02_switch {

	public static void main(String[] args) {
	  /*
	   * 
	   * switch문
	   * 1. 형식
	   *    switch(표현식){
	   *    case 갑1 : 실행문; break;
	   *    case 갑2 : 실행문; break;
	   *    default:실행문;
	   *    }
	   * 
	   * 2. 실제사용
	   *   switch (a+b){
	   *   case >= 10 : //불가능.
	   *   case 10 : //가능
	   *   case 1.5 : //불가능(표현식의 결과는 실수타입일수없다.)
	   *   case '남' : // 가능
	   *   case"홍길동": //가능 
	   *   }
	   *    Test02.java
             나이를 입력 받아 "성인" 또는 "미성년자" 출력
	   * */
       Scanner sc = new Scanner(System.in);
       System.out.println("나이를 입력하세요");
       int age = sc.nextInt();
       
         switch (age/10) {
         case 1: System.out.println("미성년자");break;
         case 0: System.out.println("미성년자");break;
         default: System.out.println("성인");break;
         }
         switch (age/10) {
         case 1: 
         case 0: JOptionPane.showMessageDialog(null,"미성년자");break;
         default:JOptionPane.showMessageDialog(null,"성인");break;
         }
		
		
	}

}
