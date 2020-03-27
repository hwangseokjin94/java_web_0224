package com.koreait.ex;

import javax.swing.JOptionPane;

public class Ex02_switch {

	public static void main(String[] args) {
		
		/*
		 * switch 문
		 * 
		 * 1. 형식
		 *    switch (표현식) {
		 *    case 값1 : 실행문; break;
		 *    case 값2 : 실행문; break;
		 *    default: 실행문;
		 *    }
		 * 
		 * 2. 실제 사용
		 *    switch (a + b) {
		 *    case >= 10 :  // 불가능.
		 *    case 10 :  // 가능.
		 *    case 1.5 :  // 불가능. (표현식의 결과는 실수 타입일 수 없다.)
		 *    case '남' :  // 가능.
		 *    case "홍길동" :  // 가능.
		 *    }
		 */
		
		int age = Integer.parseInt(  JOptionPane.showInputDialog("나이를 입력하세요.")  );
		
		switch ( age / 10 ) {
		case 0:
		case 1: JOptionPane.showMessageDialog(null, "미성년자");
				break;
		default: JOptionPane.showMessageDialog(null, "성인");
		}
		
	}

}
