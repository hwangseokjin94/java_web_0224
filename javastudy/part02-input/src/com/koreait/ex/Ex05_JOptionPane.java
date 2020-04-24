package com.koreait.ex;

import javax.swing.JOptionPane;

public class Ex05_JOptionPane {

	public static void main(String[] args) {
		
		/*
		 * JOptionPane 클래스
		 * 
		 *  1. GUI 컴포넌트(창)를 통해 입출력
		 *  2. swing 컴포넌트 이용
		 *     1) javax.swing 패키지를 사용
		 *     2) import 후 사용
		 *  3. JOptionPane 메소드
		 *     1) 입력 창
		 *        String 변수 = JOptionPane.showInputDialog("입력메시지");
		 *        - 주의사항
		 *          모든 입력은 String 타입으로 입력된다.
		 *     2) 출력 창
		 *        JOptionPane.showMessageDialog(null, "출력메시지");
		 */
		
		// 성명, 나이, 키, 성별 입력받아 출력하기
		
		// 1) 입력
		String name = JOptionPane.showInputDialog("성명을 입력하세요.");
		String strAge = JOptionPane.showInputDialog("나이를 입력하세요.");
		String strHeight = JOptionPane.showInputDialog("키를 입력하세요.");
		String strGender = JOptionPane.showInputDialog("성별을 입력하세요.");
		
		// 2) 입력된 문자열을 타입에 맞게 파싱(parsing)
		int age = Integer.parseInt(strAge);
		double height = Double.parseDouble(strHeight);
		char gender = strGender.charAt(0);  // 파싱은 아니고, 첫 번째 글자만 사용
		
		// 3) 출력
		String message = "성명=" + name + ", 나이=" + age + ", 키=" + height + ", 성별=" + gender;
		JOptionPane.showMessageDialog(null, message);

	}

}





