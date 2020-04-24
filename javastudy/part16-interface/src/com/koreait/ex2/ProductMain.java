package com.koreait.ex2;

public class ProductMain {

	public static void main(String[] args) {
	Product[] list = new Product[2];
	list[0] = new TV();
	list[1] = new Computer();
	for(Product p : list) {
		p.info();
	}

	}

}
