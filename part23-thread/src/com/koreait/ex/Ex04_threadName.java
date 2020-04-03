package com.koreait.ex;

//Thread A
class ThreadA extends Thread {
	public ThreadA() {
		setName("스레드 A");
	}

	@Override
	public void run() {
		System.out.println("ThreadA의 이름 :" + getName());
	}
}

//Thread B
class ThreadB extends Thread {
	@Override
	public void run() {
		System.out.println("ThreadB의 이름 :" + getName());
	}
}

public class Ex04_threadName {
	public static void main(String[] args) {
		SumThread adder1 = new SumThread("adder1", 1, 10); // sum : 55
		SumThread adder2 = new SumThread("adder2", 11, 100); // sum : 4995

		// adder1 과 adder2 를 동작시키면 1~100 사이 합 5050 이 나타나야 한

		adder1.start();
		adder2.start();

		// adder1이 종료될떄까지 adder2에게 기다리라고하면된다.
		// main 도 adder2가 종료될때까지 기다려야한다.
		// join():기다리라.
		try {
			adder1.join(); // adder1 종료까지 기다리라.
			adder2.join(); // adder2 종료까지 기다리라.

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(adder1.getName() + "의 합 : " + adder1.getSum());
		System.out.println(adder2.getName() + "의 합 : " + adder2.getSum());

		System.out.println("총 합 : " + (adder1.getSum() + adder2.getSum()));

	}
}
