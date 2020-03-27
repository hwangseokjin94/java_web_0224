package com.koreait.ex;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex04_do_while {

	public static void main(String[] args) {
		
		// while 문 vs do while 문
		// while 문은 한 번도 실행되지 않을 수 있으나,
		// do while 문은 반드시 한 번은 실행된다.

		// 1. 1 ~ 10
		int a = 1;
		do {
			System.out.println(a);
			a++;
		} while (a < 11);
		
		
		// 2. 10 ~ 1
		int b = 10;
		do {
			System.out.println(b);
			b--;
		} while (b > 0);
		
		
		// 3. 'a' ~ 'z'
		char ch = 'a';
		do {
			System.out.println(ch);
			ch++;
		} while (ch <= 'z');
		
		
		// 4. 0 이상의 정수를 입력받기
		// 0 미만의 정수가 입력되면 재입력하기
		Scanner sc = new Scanner(System.in);
		
		int n;
		do {
			System.out.print("양수만 입력하세요 >> ");
			n = sc.nextInt();
		} while (n < 0);
		
		System.out.println("입력된 양수는 " + n + "이다.");
		
		sc.close();
		
		// 5. 수도 맞추기
		// 대한민국의 수도를 맞출때까지 묻기
		// 몇 번만에 맞췄는지 함께 출력
		String city = null;
		int count = 0;
		
		do {
			city = JOptionPane.showInputDialog("대한민국의 수도를 입력하세요.");
			count++;
		} while ( !city.equals("서울") && !city.equalsIgnoreCase("seoul") );
		
		JOptionPane.showMessageDialog(null, count + "번만에 정답.");
		
	}

}
