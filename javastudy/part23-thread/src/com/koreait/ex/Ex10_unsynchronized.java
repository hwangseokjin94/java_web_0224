package com.koreait.ex;

//Maker
class Maker {

	private String message;

	public Maker(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

//Sender
class Sender extends Thread {
	// field
	private Maker maker;

	// constructor

	public Sender(Maker maker) {
		this.maker = maker;
	}

	@Override
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		maker.setMessage("보고싶다");
		System.out.println("전송 완료");
	}

}

//Reader
class Reader extends Thread {
	private Maker maker;

	public Reader(Maker maker) {
		this.maker = maker;
	}

	@Override
	public void run() {
		System.out.println(maker.getMessage());
		System.out.println("수신완료");
	}
}

public class Ex10_unsynchronized {
	public static void main(String[] args) {
		Maker maker = new Maker("사랑해");
		Sender sender = new Sender(maker);//먼저 실행되기를 기대
		Reader reader = new Reader(maker);//나중에 실행되기를 기대

		sender.start();  //sender의 run()메소드 호출 (먼저 호출된다는 보장이없다.) 스레드의 생성은 JVM이정하는것
		reader.start();

		try {
			sender.join();
			reader.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
