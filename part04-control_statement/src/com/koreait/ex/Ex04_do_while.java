package com.koreait.ex;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex04_do_while {

	public static void main(String[] args) {
		//while 문 vs do while문
		//while문은 한번도 실행된지 않을수 있으나
		// do while 문은 반드시 한번은 실행된다. 
		//1~10
		int a  =   0 ;
		do {
			System.out.println(a);
			a++;
			
		}while(a<11);
		
		
		//10~1
		
		do {
			System.out.println(a);
			a--;
			
		}while(a>0);
		
		
		// a~z
		char ch ='a';
		do {
			
			System.out.print(ch );
			ch++;
		}while(ch<='z');
		
		//4. 0이상의 정수를 입력받기
		// 0미만의 정수가 입력되면 재입력하기
	/*	Scanner sc = new Scanner(System.in);
		int num ;
		int numCheck =sc.nextInt();
		do {
			
			System.out.print("0이상입력해주세요");
			num =sc.nextInt();
		}while(numCheck<0);
		System.out.println("입력하신수는"+numCheck+"입니다");
	*/	
		
		
		//5. 수도 맞추기
		// 대한민국의 수도를 맞출때까지 묻기
		//몇번만에 맞췄는지 함께출력
		String city = null;
		
		int count = 0 ;
		do {
			city =JOptionPane.showInputDialog("대한민국의 수도는?");
			
			count++;
		}while(!city.equals("서울") && !city.equalsIgnoreCase("seoul"));
	
		JOptionPane.showMessageDialog(null, count+"번째 정답입니다.");
		
		

	}//main

}
