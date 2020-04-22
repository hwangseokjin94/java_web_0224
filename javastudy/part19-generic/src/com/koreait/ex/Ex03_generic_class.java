package com.koreait.ex;

class Marine {
	// Method
	public void shoot() {
		System.out.println("탕탕탕!");
	}
}

class Tank {
	// Method
	public void Shoot() {
		System.out.println("펑~~~~!");
	}
}

//제네릭클래스 Bunker
class Bunker<T> { // 마린만들어갈수잇다가정

	// field
	private T[] arr; // 배열을 만든건아니고, 제네릭타입으로 배열타입으로 선언은 가능!
	private int idx;
	private int arrLength;

	// Constructor
	public Bunker(int count) {
		// arr = new T[count]; //제네릭 타입으로 배열의 생성은 불가능!
		arr = (T[]) (new Object[count]);
		arrLength = count;
	}// 전달해준 숫자만큼 T타입에 배열이생김

//	public void shoot() {
//		for (int i = 0; i < arr.length; i++) {
//
//		}
//	}

	public void add(T obj) {
		if (idx == arrLength) {
			return;
		}
		arr[idx++] = obj;
	}

}

public class Ex03_generic_class {
	public static void main(String[] args) {

		Bunker<Marine> bunker = new Bunker<>(3);
		bunker.add(new Marine());
		bunker.add(new Marine());
		bunker.add(new Marine());

		//bunker.add(new Tank());// 허용되지않는작업 탱그는 벙커에 들어가지않는다.
		//제네릭을 배우기전에는 인터페이스를 이용하여서 작업을하였다. 제네릭을 숙지할수있도록해야됨.
		//이렇게 구현을 못하더라도 이해를 하면되고 컬렉션을 배우기위해 선행조건이라 생각하면된다.	
		
	
		
		
		
	}
}
