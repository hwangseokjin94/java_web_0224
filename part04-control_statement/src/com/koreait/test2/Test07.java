package com.koreait.test2;

import javax.swing.JOptionPane;

public class Test07 {

	public static void main(String[] args) {
		
		String id = "";
		String pw = "";
		final int MAX_COUNT = 5;  // 최대 횟수 "상수" (상수는 대문자로)
		int count = 0;  // 카운팅
		
		// 1. id
		do {
			id = JOptionPane.showInputDialog("ID를 입력하세요.");
		} while ( !id.equals("admin") );
		
		// 2. pw
		do {
			count++;
			if (count > MAX_COUNT) {
				JOptionPane.showMessageDialog(null, "비밀번호 입력 횟수 초과");
				return;  // 리턴타입이 없는 메소드의 종료(main 메소드)
				// System.exit(0);
			}
			pw = JOptionPane.showInputDialog("PW를 입력하세요.(최대 5회)");
		} while ( !pw.equals("1234") );
		
		// 3. 출력
		JOptionPane.showMessageDialog(null, "로그인 성공");

	}

}