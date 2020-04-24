package com.koreait.downcasting;

class Car {
	private String model;

	public Car(String model) {
		super();
		this.model = model;
	}

	public void drive() {
		System.out.println(model + "타고 드라이브중 .");
	}

}

class EV extends Car {
	private int battery;
	private final int FULL_BATTERY = 80;

	public EV(String model, int battery) {
		super(model);
		this.battery = battery;
	}

	public void charging(int battery) {
		this.battery += battery;
		if (this.battery > FULL_BATTERY) {
			this.battery = FULL_BATTERY;
		}
	}
}

class Hybrid extends EV {
	private int oil;
	private final int FULL_OIL = 50;

	public Hybrid(String model, int battery, int oil) {
		super(model, battery);
		this.oil = oil;
	}

	public void addOil(int oil) {
		this.oil += oil;
		if (this.oil > FULL_OIL) {
			this.oil = FULL_OIL;
		}
	}

}

public class Ex02_Car {
	public static void main(String[] args) {
		Car[] motors = new Car[2];

		motors[0] = new EV("bmwi", 50);
		motors[1] = new Hybrid("sonata", 30, 50);

		for (Car car : motors) {
			car.drive(); // 모든 Car가능

			if (car instanceof EV) {
				((EV) car).charging(10);
			} else if (car instanceof Hybrid) {
				((Hybrid) car).addOil(20);
			}
		}//for

		
		
	}
	
	
	
	
	
	
}
