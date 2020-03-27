package com.koreait.ex2;

public class BookMain {

	public static void main(String[] args) {
		
		Book book1 = new Book("콩쥐팥쥐", 10000);
		Book book2 = new Book("자바마스터", "마스터", 30000);
		
		book1.setSalesVolume(2000);
		book2.setSalesVolume(500);
		
		book1.printBook();
		book2.printBook();

	}

}
