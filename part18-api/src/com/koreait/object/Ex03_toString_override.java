package com.koreait.object;

//데이터 클래스 Book
class Book {
	private String title;
	private int price;
	//생성자
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
	//메소드
	//Object 클래스에는 toString()메소드가 이밎 정의 되어 있다.
	//Object(부모)의 메소드를 동일한 형태로 Book(자식)이 다시 만들면 (오버라이드)
	//Book에서 만든 toString() 을 사용할수있다.
	//지금부터 toString ()메소드를 오버라이드 한다.
	@Override
	public String toString() {
		String message = "제목 : " +title  + " , 가격" +price ;
		return message;
	}

}

public class Ex03_toString_override {
	public static void main(String[] args) {
		Book myBook=  new Book("자바마스터", 30000);
		System.out.println(myBook);
		System.out.println(myBook.toString());//위와 같은코드이다
		
	}
}
