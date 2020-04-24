package com.koreait.test;

import javax.swing.JOptionPane;

public class Test06 {

	public static void main(String[] args) {
		
		String strKor = JOptionPane.showInputDialog("국어 점수를 입력하세요");
		String strEng = JOptionPane.showInputDialog("영어 점수를 입력하세요");
		String strMat = JOptionPane.showInputDialog("수학 점수를 입력하세요");
		
		/* 정수로 변환
		int kor = Integer.parseInt(strKor);
		int eng = Integer.parseInt(strEng);
		int mat = Integer.parseInt(strMat);
		*/
		
		double kor = Double.parseDouble(strKor);
		double eng = Double.parseDouble(strEng);
		double mat = Double.parseDouble(strMat);
		
		double average = (kor + eng + mat) / 3;
		
		char grade = average >= 90 ? 'A' : average >= 80 ? 'B' : average >= 70 ? 'C' : average >= 60 ? 'D' : 'F';
		
		JOptionPane.showMessageDialog(null, "평균은 " + average + "점, 학점은 " + grade + "학점이다.");
		
		// System.out.println("평균은 " + average + "점, 학점은 " + grade + "학점이다.");
		// System.out.printf("평균은 %10.2f점, 학점은 %c학점이다.%n", average, grade);

	}

}
