package com.koreait.ex;

import javax.swing.JOptionPane;

public class Ex02_Math_random {

	public static void main(String[] args) {
		
		/*
		 * Math 클래스
		 *  1. 수학에 관련된 값이나 메소드(함수)들을 구현한 클래스
		 *  2. 객체(인스턴스) 생성이 없다.
		 *  3. 난수 발생 메소드
		 *     random()
		 *  4. 실제 사용
		 *     1) Math.random()
		 *     2) 난수 범위 : 0 ~ 0.999999
		 *     3) 원하는 범위 : (int)(Math.random() * 개수) + 시작값
		 *     4) 확률 : Math.random()
		 */
		
		// 1. 주사위 던지기
		//int dice = (int)(Math.random() * 6) + 1;
		//JOptionPane.showMessageDialog(null, "주사위 : " + dice);
		
		// 2. 확률 (30% 확률로 "강화성공", 나머지 확률로 "강화실패")
		String message = Math.random() <= 0.3 ? "강화성공" : "강화실패";
		JOptionPane.showMessageDialog(null, message);
		
	}

}
