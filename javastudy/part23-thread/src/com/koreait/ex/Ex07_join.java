package com.koreait.ex; //유저가 계산기를 사용하는 상황구현

//Adder
class Adder {
	private int rentalCount;

	public Adder() {
		rentalCount = 0;
	}

	public int add(int from, int to) {
		rentalCount++;
		int sum = 0;
		for (int n = from; n < to + 1; n++) {
			sum += n;
		}
		return sum;
	}
	

	public void rentalCountInfo() {
		System.out.println("렌탈 횟수 : " + rentalCount + "회");

	}


}

//user
class User extends Thread{
	private Adder adder;

	public User(Adder adder) {
		this.adder = adder;
	}
	

	public void useAdder() {
		System.out.println(adder.add(1, 10));
		System.out.println(adder.add(11, 20));
		System.out.println(adder.add(21, 30));
		System.out.println(adder.add(31, 40));
		System.out.println(adder.add(41, 100));
		
	}
	
	@Override
	public void run() {
		useAdder();	
	}
	
	

}

public class Ex07_join {
	public static void main(String[] args) throws Exception {

		Adder calculator = new Adder();
		User user = new User(calculator);
		user.start();
		
		
			user.join();
		
		
		calculator.rentalCountInfo();
		
	}
}
