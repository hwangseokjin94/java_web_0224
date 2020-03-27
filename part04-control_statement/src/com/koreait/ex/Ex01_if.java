package com.koreait.ex;

import javax.swing.JOptionPane;

public class Ex01_if {

	public static void main(String[] args) {
		
		int a = Integer.parseInt(  JOptionPane.showInputDialog("정수를 입력하세요.")  );
		
		if ( a > 0 ) {
			JOptionPane.showMessageDialog(null, "양수");
		} else if ( a == 0 ) {
			JOptionPane.showMessageDialog(null, "ZERO");
		} else {
			JOptionPane.showMessageDialog(null, "음수");
		}

		
		
		String strNum = JOptionPane.showInputDialog("정수를 입력하세요.");
		
		if (strNum.equals("0")) {
			JOptionPane.showMessageDialog(null, "ZERO");
		}
		
		
	}

}
