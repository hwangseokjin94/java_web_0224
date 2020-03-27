package com.koreait.ex;

import javax.swing.JOptionPane;

public class Ex05_for {

	public static void main(String[] args) {
		
		// 1. 1 ~ 10
		int a;  // for 문 외부에서도 사용이 가능하다.
		for (a = 1; a < 11; a++) {
			System.out.println(a);
		}
		
		for (int b = 1; b < 11; b++) {  // for 문 내부에서만 사용이 가능하다.
			System.out.println(b);
		}
		
		System.out.println(a);
		// System.out.println(b);  // 사용 불가
		
		
		// 2. 사용자가 입력한 값만큼 "Hello" 출력하기
		int count = Integer.parseInt(JOptionPane.showInputDialog("몇 번 할까요?"));
		String message = "";
		
		for (int b = 0; b < count; b++) {
			message += "Hello\n";
		}
		
		JOptionPane.showMessageDialog(null, message);		
		
	}

}
