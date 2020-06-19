package com.koreait.spring;

public class Gugudan {

	// Field
	private int startDan;
	private int endDan;
	private int startNum;
	private int endNum;
	private Calculator calculator;
	
	// Constructor
	public Gugudan() {}
	
	// Method
	public void gugudanInfo() {
		for (int dan = startDan; dan <= endDan; dan++) {
			for (int num = startNum; num <= endNum; num++) {
				System.out.println(dan + "X" + num + "=" + calculator.multiplication(dan, num));
			}
		}
	}
	public int getStartDan() {
		return startDan;
	}
	public void setStartDan(int startDan) {
		this.startDan = startDan;
	}
	public int getEndDan() {
		return endDan;
	}
	public void setEndDan(int endDan) {
		this.endDan = endDan;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
}
