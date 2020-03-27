package com.koreait.ex;

// 데이터클래스 Book
class Book {
	
	// Field
	String title;
	String writer;
	int price;
	int salesVolume;
	boolean isBestSeller;
	
	// Constructor
	Book() {
		// 생성자 내부에서는 this()를 다른 생성자를 호출하는 용도로 사용한다.
		this("콩쥐팥쥐", 10000);  // 다른 생성자 중에서 "파라미터를 2개" 처리하는 생성자를 호출한다.
	}
	Book(String title, int price) {
		this(title, "작가미상", price);  // 다른 생성자 중에서 "파라미터를 3개" 처리하는 생성자를 호출한다.
	}
	Book(String title, String writer, int price) {
		this.title = title;
		this.writer = writer;
		this.price = price;
	}
	
	// Method
	void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
		isBestSeller = salesVolume >= 1000;
	}
	void printBook() {
		System.out.println("제목 : " + title);
		System.out.println("저자 : " + writer);
		System.out.println("가격 : " + price);
		System.out.println("판매량 : " + salesVolume + "(" + (isBestSeller ? "베스트셀러" : "일반서적") + ")");
	}
	
}

public class Ex02_Book {

	public static void main(String[] args) {
		
		Book book1 = new Book();
		book1.setSalesVolume(2000);
		book1.printBook();
		
		Book book2 = new Book("심청전", 15000);
		book2.setSalesVolume(500);
		book2.printBook();

	}

}
