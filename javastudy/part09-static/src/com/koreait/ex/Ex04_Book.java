package com.koreait.ex;

// 데이터클래스 Book
class Book {
	
	// Field
	
	// static 필드
	// 모든 인스턴스가 공유하는 "하나의" 변수
	static int count = 0;  // new Book() 이 호출될때마다 1씩 증가되는 변수
	
	// 인스턴스 필드(non-static) : 인스턴스마다(book1, book2, book3) 개별적으로 가지는 값
	// 모든 인스턴스는 serialNo 의 초기화는 0 이다.
	int serialNo;
	
	
	
	// 방법1.
	// Constructor
	/*
	Book() {
		count++;  // 책의 개수
		serialNo = count;
	}
	*/
	
	// 방법2.
	// Instance block (인스턴스 블록) : 인스턴스가 생성될때마다 실행되는 블록
	{
		count++;
		serialNo = count;
	}
	
}

public class Ex04_Book {

	public static void main(String[] args) {
		
		Book book1 = new Book();  // 고유번호 : 1
		Book book2 = new Book();  // 고유번호 : 2
		Book book3 = new Book();  // 고유번호 : 3
		
		System.out.println("book1의 고유번호는 " + book1.serialNo + "이다.");
		System.out.println("book2의 고유번호는 " + book2.serialNo + "이다.");
		System.out.println("book3의 고유번호는 " + book3.serialNo + "이다.");

	}

}
