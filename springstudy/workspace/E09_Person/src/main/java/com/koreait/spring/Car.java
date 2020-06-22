package com.koreait.spring;

public class Car {
	//Field
	private String model;
	private int price;
	//Constructor
	public Car() {}
	public Car(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	//Method
	public void carInfo() {
		System.out.println("자동차 모델" + model);
		System.out.println("자동차 가격"+ price);
 	
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
	
	
	
	
}
