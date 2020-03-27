package com.koreait.ex2;

public class BookMain {

	public static void main(String[] args) {

		Book book = new Book();

		book.title = "멘토씨리즈 자바";
		book.writer = "코리아교육그룹 교육연구소";
		book.price = 25000;
		book.isBestSeller = true;

		System.out.println("제목 = " + book.title);
		System.out.println("저자 = " + book.writer);
		System.out.println("가격 = " + book.price);
		System.out.println(book.isBestSeller ? "베스트셀러" : "일반서적");

	}

}
