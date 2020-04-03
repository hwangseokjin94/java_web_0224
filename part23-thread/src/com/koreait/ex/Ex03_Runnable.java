package com.koreait.ex;
//더 자주 사용되는 스레드 생성 방법

//Rnuable 인터페잇스 구현 클래스 ->스래드

class Runnabletask implements Runnable {
	// Field
	private String taskName;

	// Constructor
	public Runnabletask(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);// 0.5 Thread의 sleep()메소드 호출
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(taskName + "실행");
	}

}

public class Ex03_Runnable {
	public static void main(String[] args) {
		Runnable task = new Runnabletask("작업");
		Thread threadTask = new Thread(task);
		threadTask.start();
		System.out.println("main 종료");

	}
}
