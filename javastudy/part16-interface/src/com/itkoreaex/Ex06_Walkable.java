package com.itkoreaex;
//인터페이스 :타입으로 사용하기 위해서 내용이 없는 인터페이스를 활용
interface Walkable{}

//부모
class Pet {
	private String name;

	public Pet(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void feed(String food) {
		System.out.println(name + "는" + food + "를 먹는다.");
	}
}

//자식

class Dog extends Pet implements Walkable{
	//생성자
	public Dog(String name) {
		super(name);
	
	}

	

	
}

class Hamster extends Pet{

	public Hamster(String name) {
		super(name);
	}
	
}
//데이터클래스 
class Person{
	//메소드
	public void feed( Pet pet ,String food) {
		pet.feed(food);
		
	}
	public void walking(Walkable pet) {
		
	System.out.println(((Pet)pet).getName()+"와 산책하기");
		
	}
	
}




public class Ex06_Walkable {
  public static void main(String[] args) {
	
	  Person person = new Person();
	  
	  Dog dog = new Dog("맥스");
	  Hamster hamster = new Hamster("햄식이");
	  
	  person.feed(dog, "사료");
	  person.feed(hamster, "해바라기");
	  		
	  person.walking(dog);//맥스와 산책하기
	 // person.walking(hamster); //실행불가상태로만들고싶어
}
}





