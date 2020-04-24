package com.koreait.ex;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex05_for {

	public static void main(String[] args) {
	    //1. 1~10
		int a;
		for(a = 1;a<11;a++) {
			System.out.print(a+" ");
			
		}
		System.out.println();
		for(int b = 1;b<11;b++) {
			System.out.print(b+" ");
			
		}
		System.out.print(a+" ");
//		System.out.print(b+" "); a는 외부에서 변수를 사용가능하지만 b는 사용못한
									// 범위의 차이이당.
		System.out.println();
		
  //2. 사용자가 입력한 값 만큼 "hello"출력하기
		/*
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		System.out.println("숫자를 입력하세요");
		for (int i= 0;i<c;i++) {
			System.out.println("hello");
		}
		
		*/
		int count = Integer.parseInt(JOptionPane.showInputDialog("몇번할까요"));
		String message = "";
		for (int b= 0;b<count;b++) {
			message += "Hello \n";
		}
		JOptionPane.showMessageDialog(null, message);
		
		
	}//main

}
