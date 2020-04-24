package com.koreait.ex;

// 데이터클래스 Book
class Book {
	
	// Field
	String title;
	
	// Constructor
	Book() {
		// title = "제목없음";
		this("제목없음");
	}
	Book(String title) {
		this.title = title;
	}
	
	// Method
	void printBook() {
		System.out.println("책 제목 : " + title);
	}
	
}

// 데이터클래스 Person
class Person {
	
	// Field
	String name;
	Book book;  // null 상태
	
	// Constructor
	Person(String name) {
		this.name = name;
		book = new Book();
		// this(name, null);
	}
	Person(String name, String bookTitle) {
		this.name = name;
		if (bookTitle == null || bookTitle.isEmpty()) {
			book = new Book();
		} else {
			book = new Book(bookTitle);
		}
	}
	Person(String name, Book book) {
		this.name = name;
		this.book = book;
	}
	
	// Method
	void printPerson() {
		System.out.println("사람 이름 : " + name);
		// System.out.println("책 제목 : " + book.title);  아래 코드와 같지만 객체지향언어가 지향하는 방향이 아님
		book.printBook();
	}
	
}

public class Ex02_Person {

	public static void main(String[] args) {

		Person man = new Person("제임스");
		Person woman = new Person("앨리스", "멘토씨리즈 자바");
		man.printPerson();
		woman.printPerson();
		
		Book myBook = new Book("자바 웹 개발 워크북");
		Person p = new Person("데이빗", myBook);  // 생성자 작업
		p.printPerson();
		
	}

}