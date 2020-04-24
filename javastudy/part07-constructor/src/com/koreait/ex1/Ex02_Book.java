package com.koreait.ex1;

// 데이터 클래스 Book
class Book {
	
	// Field
	String title;
	String writer;
	int price;
	int salesVolume;  // 판매량
	boolean isBestSeller;  // 판매량이 1000 이상이면 true
	
	// Constructor
	Book(String _title, int _price) {
		title = _title;
		writer = "작가미상";
		price = _price;
	}
	Book(String _title, String _writer, int _price) {
		title = _title;
		writer = _writer;
		price = _price;
	}
	
	// Method
	void setSalesVolume(int _salesVolume) {
		salesVolume = _salesVolume;
		isBestSeller = salesVolume >= 1000;
	}
	void printBook() {
		System.out.println("제목 = " + title);
		System.out.println("저자 = " + writer);
		System.out.println("가격 = " + price);
		System.out.println("판매량 = " + salesVolume);
		System.out.println(isBestSeller ? "베스트셀러" : "일반서적");
	}
	
}

public class Ex02_Book {

	public static void main(String[] args) {
		
		Book book1 = new Book("콩쥐팥쥐", 10000);
		Book book2 = new Book("자바마스터", "마스터", 30000);
		
		book1.setSalesVolume(2000);
		book2.setSalesVolume(500);
		
		book1.printBook();
		book2.printBook();

	}

}
