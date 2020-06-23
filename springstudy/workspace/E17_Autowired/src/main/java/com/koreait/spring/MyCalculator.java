package com.koreait.spring;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;

public class MyCalculator {
	
//	@Qualifier("calc") //calc라는 bean을
	@Autowired     	   //자동으로 주입하라.
	private Calculator calculator;
	

	//method
	public void alarm() {
		System.out.println("alarm");
	}
	
	
	// Method
		public void addition(int num1,int num2) {
			
		calculator.addition(num1, num2);
		}
		public void substraction(int num1,int num2) {
			calculator.substraction(num1, num2);
			
		}
		public void multiplication(int num1,int num2) {
			calculator.multiplication(num1, num2);
		}
		public void division(int num1,int num2) {
			calculator.division(num1, num2);
		}

	
	
	
	
	
	
	
}
