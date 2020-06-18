package com.koreait.spring;

public class MyCalculator {
	
	//field
	private int num1;
	private int num2;
	private Calculator calculator;
	
	//Constructor
	public MyCalculator() {
		
	}

	public MyCalculator(int num1, int num2, Calculator calculator) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.calculator = calculator;
	}
	//method
	public void addtion() {
		calculator.addition(num1,num2);
	}
	public void substraction() {
		calculator.substraction(num1,num2);
	}
	public void multiplication() {
		calculator.multiplication(num1,num2);
	}
	public void division() {
		calculator.division(num1,num2);
	}

	
	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	
	
}
