package com.koreait.downcasting;

class Animal {
	public void eat() {
		System.out.println("먹이를 먹는다");
	}
}

class Dolphin extends Animal {
	
	@Override
	public void eat() {
		System.out.println("물고기를 먹는다");
	}
	//Dolphin 만 가지고 있는 메소드
	public void swim() {
		System.out.println("돌고래가 헤엄을 친다.");
	}
}

class Eagle extends Animal {

	@Override
	public void eat() {
		System.out.println("육고기를 먹는다");
	}
	// Eagle 만가지고있는 fly()
	public void fly() {
		System.out.println("독수리가 난다.");
	}
}

public class Ex03_Animal {
	public static void main(String[] args) {
		Animal[] animals = new Animal[2];
		
		animals[0] = new Dolphin();
		animals[1] = new Eagle();
		
		for(Animal animal : animals) {
			animal.eat(); //다형성 :오버라이드ㄱ된 메소드가 실행되므로 animal 에 따라 실행결과가 다르다.
			if(animal instanceof Dolphin ) {
				((Dolphin)animal).swim();
			}else if(animal instanceof Eagle) {
				((Eagle)animal).fly();
			}
		}
		
		
		
	}
}
