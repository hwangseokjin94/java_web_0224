package com.koreait.test2;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Test09 {

	public static void main(String[] args) {
		
		String message = "";
		
		for (int n = 1; n < 10; n++) {
			for (int dan = 2; dan < 10; dan++) {
				message += (dan + "x" + n + "=" + (dan*n) + "\t");
			}
			message += "\n";
		}
		
		JOptionPane.showMessageDialog(null, new JTextArea(message));

	}

}
