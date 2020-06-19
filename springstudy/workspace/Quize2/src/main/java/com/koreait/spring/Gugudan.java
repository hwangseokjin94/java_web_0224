package com.koreait.spring;

public class Gugudan {
	
	private int startDan;
	private int endDan;
	private int startNum;
	private int endNum;
	private Calculator calculator;
	
	//
	public Gugudan() {}
	
	//
	public void cal() {
		calculator.cal(startDan , endDan , startNum , endNum);
		
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
