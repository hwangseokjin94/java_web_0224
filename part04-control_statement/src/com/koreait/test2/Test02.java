package com.koreait.test2;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Test02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("출력할 구구단 입력 >> ");
		int dan = sc.nextInt();
		
		// 1. 콘솔 출력
		for (int n = 1; n < 10; n++) {
			System.out.println(dan + "x" + n + "=" + (dan*n));
		}
		
		sc.close();
		
		
		// 2. 대화상자 출력
		String message = "";
		for (int n = 1; n < 10; n++) {
			message += (dan + "x" + n + "=" + (dan*n) + "\n");
		}
		JOptionPane.showMessageDialog(null, message);

	}

}
