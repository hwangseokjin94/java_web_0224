package com.koreait.spring;

public class BMICalculator {
	
	
	private double normal; // 정상(bmi : 20~25)

	private double over; // 과체중(bmi : 26~30)

	private double obesity; // 비만(bmi : 31~)
	private Person person;
	
	
	public BMICalculator() {}
	public void fn_bmi() {
		double bmi =person.getWeight()/(person.getHeight()*person.getHeight());
		String result="";
		if(bmi>20 && bmi<25) {
			result="(정상)";
		}else if(bmi>26 && bmi<30) {
			result="(과체중)";
		}else {
			result="(비만)";
		}
		
		System.out.println("체질량지수 : "+bmi +result);
	}
	public double getNormal() {
		return normal;
	}
	public void setNormal(double normal) {
		this.normal = normal;
	}
	public double getOver() {
		return over;
	}
	public void setOver(double over) {
		this.over = over;
	}
	public double getObesity() {
		return obesity;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	

}
