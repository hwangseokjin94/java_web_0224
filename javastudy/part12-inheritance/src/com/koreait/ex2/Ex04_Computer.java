package com.koreait.ex2;

class Computer {
	String model;
	int price;

	Computer(String model, int price) {
		this.model = model;
		this.price = price;
	}

	void printComputer() {
		System.out.println("모델명 : " + model);
		System.out.println("가격 : " + price);
	}

}

class Notebook extends Computer {
	int battery;

	Notebook(int battery, String model, int price) {
		super(model, price);
		this.battery = battery;
	}

	@Override
	void printComputer() {
		super.printComputer();
		System.out.println("베터리 용량은" + battery);
	}

}

//자손
class Tablet extends Notebook {
	String pen;

	public Tablet(String pen, int battery, String model, int price) {
		super(battery, model, price);
		this.pen = pen;
	}

	@Override
	void printComputer() {
		super.printComputer();
		System.out.println("펜은 " + pen);
	}
}

public class Ex04_Computer {
	public static void main(String[] args) {
		Tablet tablet = new Tablet("S-pen", 100, "NOTE", 200);
		tablet.printComputer();
	}
}
