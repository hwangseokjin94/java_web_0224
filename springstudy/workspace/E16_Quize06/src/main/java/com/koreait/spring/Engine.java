package com.koreait.spring;

public class Engine {

	private String fuelType;  // 가솔린, 디젤

	private int cc;  // 배기량 1,991

	private int hp;  // 마력 245

	private double fuelEfficiency;  // 연비 12.5
	
	public Engine() {
		// TODO Auto-generated constructor stub
	}

	public Engine(String fuelType, int cc, int hp, double fuelEfficiency) {
		super();
		this.fuelType = fuelType;
		this.cc = cc;
		this.hp = hp;
		this.fuelEfficiency = fuelEfficiency;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public double getFuelEfficiency() {
		return fuelEfficiency;
	}

	public void setFuelEfficiency(double fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}
	
	
}
