package com.koreait.test;

class Product {
	private String model;
	private int price;

	public Product(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public int getPrice() {
		return price;
	}

}

class TV extends Product {

	public TV(String model, int price) {
		super(model, price);

	}

}

class Computer extends Product {

	public Computer(String model, int price) {
		super(model, price);

	}

}

//구매자
class Customer {
	private int money;
	private int bonusPoint;
	private Product[] cart = new Product[2];
	private int numOfProduct;

	public Customer(int money) {
		this(money, 0);// 밑에생성자 호출함.

	}

	public Customer(int money, int bonusPoint) {

		this.money = money;
		this.bonusPoint = bonusPoint;
	}

	public void buy(Product product) {// product 구매 후 cart 에 담기, 보너스포인트는 구매액의 5%
		if (money < product.getPrice()) {
			System.out.println("돈이" + (product.getPrice() - money) + " 부족합니다.");
			return;
		}
		money -= product.getPrice();
		bonusPoint += (int) (product.getPrice() * 0.05);
		cart[numOfProduct++] = product;
	}

	void purchaseList() {// 구매 목록, 총 구매액, 보너스포인트, 구매자가 구매 후 남은 돈 출력
		int total = 0 ;
		for(int i = 0  ; i < numOfProduct ;  i ++) {
			
			System.out.println(cart[i].getModel()+" : "+cart[i].getPrice());
			total += cart[i].getPrice();
		}
		System.out.println("총 구매액 : "+total);
		System.out.println("보너스 포인트 : "+bonusPoint);
		System.out.println("남은 돈 : "+money);

	}
}

public class Test02 {
	public static void main(String[] args) {
		Customer c1 = new Customer(1000);
		Customer c2 = new Customer(1000, 10);
		c1.buy(new TV("삼성",300));
		c1.buy(new Computer("삼성컴퓨터", 200));
		c1.purchaseList();
		
		
		System.out.println("=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ");
		
		
		
		c2.buy(new TV("LG", 500));
		c2.buy(new Computer("LG컴퓨터", 100));
		c2.purchaseList();
	}
}
