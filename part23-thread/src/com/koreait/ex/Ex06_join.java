package com.koreait.ex;

//SumThread
class SumThread extends Thread {
	
	// Field
	private int sum;
	private int startNum;
	private int stopNum;
	
	// Constructor
	public SumThread(String name, int startNum, int stopNum) {
		setName(name);
		this.startNum = startNum;
		this.stopNum = stopNum;
	}
	
	// Method
	public int getSum() {
		return sum;
	}
	public void addNum(int n) {
		sum += n;
	}
	@Override
	public void run() {
		for (int n = startNum; n < stopNum + 1; n++) {
			addNum(n);
		}
	}
	
}


public class Ex06_join {

	public static void main(String[] args) {
		
		SumThread adder1 = new SumThread("adder1", 1, 10);  // sum : 55
		SumThread adder2 = new SumThread("adder2", 11, 100);  // sum : 4995

		// adder1 과 adder2 를 동작시키면 1~100 사이 합 5050 이 나타나야 한다.
		
		adder1.start();
		adder2.start();
		
		
		// adder1 이 종료될때까지 adder2 에게 기다리고 하면 된다.
		// main 도 adder2 가 종료될때까지 기다려야 한다.
		// join() : 기다리라.
		try {
			adder1.join();  // adder1 종료까지 기다리라.
			adder2.join();  // adder2 종료까지 기다리라.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(adder1.getName() + "의 합 : " + adder1.getSum());
		System.out.println(adder2.getName() + "의 합 : " + adder2.getSum());
		
		System.out.println("총 합 : " + (adder1.getSum() + adder2.getSum()));
		
	}

}


