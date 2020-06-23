package com.koreait.spring;

//import org.springframework.stereotype.Component;

//@Component("calc") //내가 calc다.
public class Calculator {
	//field
	
	public Calculator() {	//디폴트 생성자
		// TODO Auto-generated constructor stub
	}

 
	// Method
	public void addition(int num1,int num2) {
		int result = num1 + num2;
		System.out.println(num1+"+"+num2+"="+result);
	}
	public void substraction(int num1,int num2) {
		int result = num1 - num2;
		System.out.println(num1+"-"+num2+"="+result);
	}
	public void multiplication(int num1,int num2) {
		int result = num1 * num2;
		System.out.println(num1+"*"+num2+"="+result);
	}
	public void division(int num1,int num2) {
		int result = num1 / num2;
		System.out.println(num1+"/"+num2+"="+result);
	}

	
	
}
