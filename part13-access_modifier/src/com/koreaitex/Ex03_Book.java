package com.koreaitex;

class Book {
	private String title;
	private String writer;
	private int price;
	private int salesVolume;
	private boolean isBestSeller;

	// 메소드
	// setter :필드에 데이터 저장하기위한 용도.
	// 파라미터에받아오고 데이터를 저장한다.
	public void setTitle(String title) {
		this.title = title;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
		if (salesVolume > 1000) {
//			this.isBestSeller = true ; 이렇게하지말고 밑에 set방식을 이용
			setBestSeller(true);
		}
	}

	// setBestSeller는 private 이다.
	private void setBestSeller(boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
	}

	// getter : 필드의 값을 확인

	public String getTitle() {
		return title;
	}

	public String getWriter() {
		return writer;
	}

	public int getPrice() {
		return price;
	}

	public int getSalesVolume() {
		return salesVolume;
	}

	public boolean isBestSeller() {
		return isBestSeller;
	}

}

public class Ex03_Book {
	public static void main(String[] args) {
		Book book = new Book();
		// book 객체의 필드값에 저장을 위한 메소드 호출한다.
		// setter
		book.setTitle("콩쥐팥쥐");
		book.setWriter("한솔 출판사 연구소");
		book.setPrice(10000);
		book.setSalesVolume(1000);
		// book.setBestSeller(false);//salesVolume 이 1000이상이면 true , salesVolume관계를 처리하지
		// 않으면 잘못된코드가 삽입될 우려가 있다.
		// book 객체의 필드 값으 확인하기 위한 메소드르 ㄹ호출한다.
//		getter
		System.out.println("제목" + book.getTitle());
		System.out.println("저자 " + book.getWriter());
		System.out.println("가격 " + book.getPrice());
		System.out.println("판매량 " + book.getSalesVolume());
		System.out.println(book.isBestSeller() ? "베스트셀러" : "일반서적");
		System.out.println("저자 " + book.getWriter());
	}
}
