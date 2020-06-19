package com.koreait.spring;

import java.util.ArrayList;

public class Person {

	private String name;  // 이름

	private double weight; // 몸무게

	private double height; // 키

	private BMICalculator bmiCalculator;  // bmi 계산기(체질량지수)

	private ArrayList<String> hobbies; // 최소 3개의 취미
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public void personInfo() {
		System.out.println("성명 : "+name);
		System.out.println("몸무게 : "+weight);
		System.out.println("키 : "+height);
		
		System.out.print("취미 : ");		
		for(int i = 0 ,len = hobbies.size(); i <len ; i ++) {
			
			System.out.print(hobbies.get(i)+"  ");
		}
		System.out.println();

	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public BMICalculator getBmiCalculator() {
		return bmiCalculator;
	}

	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	
	
}
