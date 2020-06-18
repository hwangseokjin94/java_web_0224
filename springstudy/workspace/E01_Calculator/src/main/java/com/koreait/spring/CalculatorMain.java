package com.koreait.spring;

public class CalculatorMain {

	public static void main(String[] args) {
	
		
		//1.디폴트 생성자 +setter
		Calculator calculator1 = new Calculator();
		MyCalculator myCalculator1 = new MyCalculator();
		myCalculator1.setNum1(10);
		myCalculator1.setNum2(3);
		myCalculator1.setCalculator(new Calculator());//주입
		myCalculator1.addtion();
		myCalculator1.substraction();
		myCalculator1.multiplication();
		myCalculator1.division();
		
		
		//2.필드 생성자
		
		MyCalculator myCalculator2 = new MyCalculator(100,30,new Calculator()); 
		myCalculator2.addtion();
		myCalculator2.substraction();
		myCalculator2.multiplication();
		myCalculator2.division();
		
	}

}
