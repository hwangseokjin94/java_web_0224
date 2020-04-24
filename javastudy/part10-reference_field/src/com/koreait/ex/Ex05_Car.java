package com.koreait.ex;

// 데이터클래스 Engine
class Engine {
	
	// Field
	String fuelType;  // 가솔린, 디젤
	int cc;  // 배기량 1,991
	int hp;  // 마력 245
	double fuelEfficiency;  // 연비 10.5
	
	// Constructor
	Engine(String fuelType, int cc, int hp, double fuelEfficiency) {
		this.fuelType = fuelType;
		this.cc = cc;
		this.hp = hp;
		this.fuelEfficiency = fuelEfficiency;
	}
	
	// Method
	void printEngine() {
		System.out.println("=== 엔진사양 ===");
		System.out.println("연료 : " + fuelType);
		System.out.println("배기량 : " + cc + "cc");
		System.out.println("마력 : " + hp + "hp");
		System.out.println("연비 : " + fuelEfficiency + "km/l");
	}
	
}

// 데이터클래스 Car
class Car {
	
	// Field
	String model;
	Engine engine;
	
	// Constructor
	Car(String model, String fuelType, int cc, int hp, double fuelEfficiency) {
		this.model = model;
		engine = new Engine(fuelType, cc, hp, fuelEfficiency);
	}
	Car(String model, Engine engine) {
		this.model = model;
		this.engine = engine;
	}
	
	// Method
	void printCar() {
		System.out.println("자동차 모델 : " + model);
		engine.printEngine();
	}
	
}

public class Ex05_Car {

	public static void main(String[] args) {
		
		Car myCar = new Car("e-class", "디젤", 1991, 245, 10.5);
		myCar.printCar();
		
		Engine engine = new Engine("가솔린", 1998, 252, 11.2);
		Car yourCar = new Car("530i", engine);
		yourCar.printCar();
		
	}

}