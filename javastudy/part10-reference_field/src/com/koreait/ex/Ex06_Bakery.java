package com.koreait.ex;

// 데이터클래스 BreadAndChange
class BreadAndChange {
	
	// Field
	int bread;
	int change;
	
	// Constructor
	BreadAndChange(int bread, int change) {
		this.bread = bread;
		this.change = change;
	}
	
	// Method
	
	
}

// 데이터클래스 Bakery
class Bakery {
	
	// Field
	final int PRICE = 1000;
	int numOfBread;
	int bakeryMoney;
	
	// Constructor
	Bakery(int numOfBread, int bakeryMoney) {
		this.numOfBread = numOfBread;
		this.bakeryMoney = bakeryMoney;
	}
	
	// Method
	void printBakery() {
		System.out.println("보유빵 : " + numOfBread + "개, 보유머니 : " + bakeryMoney + "원");
	}
	BreadAndChange sell(int customerMoney) {
		// 빵, 잔돈 작업
		int numOfSellBread = customerMoney / PRICE;
		int change = customerMoney % PRICE;
		BreadAndChange bnc = new BreadAndChange(numOfSellBread, change);
		
		// Bakery 판매 처리 (빵-, 돈+)
		numOfBread -= numOfSellBread;
		bakeryMoney += (customerMoney - change);
		
		// 고객에게 빵, 잔돈 돌려주기
		return bnc;
	}
	
}

// 데이터클래스 Customer
class Customer {
	
	// Field
	int numOfBuyBread;
	int customerMoney;
	
	// Constructor
	Customer(int customerMoney) {
		this(0, customerMoney);  // 다른 생성자를 다시 호출
	}
	Customer(int numOfBuyBread, int customerMoney) {
		this.numOfBuyBread = numOfBuyBread;
		this.customerMoney = customerMoney;
	}
	
	// Method
	void printCustomer() {
		System.out.println("사온빵 : " + numOfBuyBread + "개, 남은돈 : " + customerMoney + "원");
	}
	void buy(Bakery bakery, int customerMoney) {
		
		// 돈을 낸다.
		this.customerMoney -= customerMoney;
		
		// 빵과 잔돈(bnc)을 받는다.
		// 빵집에서 파는(sell)만큼만.
		BreadAndChange bnc = bakery.sell(customerMoney);
		this.numOfBuyBread += bnc.bread;
		this.customerMoney += bnc.change;
		
	}
	
}

public class Ex06_Bakery {

	public static void main(String[] args) {
		
		Bakery paris = new Bakery(100, 100000);  // 빵100개, 100000원 보유
		Bakery tour = new Bakery(50, 50000);  // 빵50개, 50000원 보유
		
		Customer breadKiller = new Customer(50000);  // 빵0개, 50000원 보유
		
		breadKiller.buy(paris, 30000);
		breadKiller.buy(tour, 15500);
		
		paris.printBakery();
		tour.printBakery();
		breadKiller.printCustomer();

	}

}
