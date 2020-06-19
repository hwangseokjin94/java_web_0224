package com.koreait.spring;

public class Calculator {
	public Calculator() {}
	
	public void cal(int startDan ,int endDan ,int startNum , int endNum) {
		for(int i = startDan;i<endDan ; i ++) {
			for(int j = startNum ; j< endNum ; j++) {
				System.out.println( startNum +"x"+ startNum+"=" +(startDan*startNum));
			}
		}
	}
	
	
	
}
