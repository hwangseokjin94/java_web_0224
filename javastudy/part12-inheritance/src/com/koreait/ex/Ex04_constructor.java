package com.koreait.ex;

class Mother {
	String motherName;

	Mother(String motherName) {
		this.motherName = motherName;
	}
}

class Daughter extends Mother {
	String daughterName;

	Daughter(String daughterName, String motherName) {
//		super();// mother 생성자호출 :매개변수각 없ㅇ는Mother 생성자
//		super(daughterName);// mother 생성자호출
//		super("사만다");
		super(motherName);
		this.daughterName = daughterName;

	}

}

public class Ex04_constructor {

	public static void main(String[] args) {
		Daughter girl = new Daughter("앨리스","사만다");

		System.out.println("엄마 이름 :" + girl.motherName);
		System.out.println("딸 이름 :" + girl.daughterName);
	}

}
