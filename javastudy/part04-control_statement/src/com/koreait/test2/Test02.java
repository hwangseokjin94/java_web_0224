package com.koreait.test2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test02 {

	public static void main(String[] args) {
		//Test02.java
//		2 ~ 9 사이 정수를 입력 받아 해당 구구단만 출력하
      Scanner sc =new Scanner(System.in);
      System.out.println("단을 입력해주세요");
      int dan ,n;
      int a = sc.nextInt();
      for (dan=a;dan<=a;dan++) {
    	  for(n=1;n<10;n++) {
    		  System.out.println(a+"단은"+ dan+"X"+n+"="+dan*n);
    	  }
      }		
	//2.대화상자출력
      String message = "";
      
      for (n=1; n <10; n++) {
    	  message +=a+"단은"+ dan+"X"+n+"="+(dan*n)+"\n";//메세지 붙이기
      }
		JOptionPane.showMessageDialog(null, message);
		
		sc.close();
	}

}
