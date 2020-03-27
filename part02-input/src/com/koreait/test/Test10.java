package com.koreait.test;

import javax.swing.JOptionPane;

public class Test10 {

	public static void main(String[] args) {
		
		double weight = Double.parseDouble( JOptionPane.showInputDialog("몸무게") );
		double height = Double.parseDouble( JOptionPane.showInputDialog("키") );
		
		height /= 100;  // 180 -> 1.8
		
		double bmi = weight / (height * height);
		String healthCondition = bmi >= 25 ? "과체중" : bmi >= 20 ? "정상" : "저체중";
		
		JOptionPane.showMessageDialog(null, "체질량지수=" + bmi + ", " + healthCondition);
				
	}

}
