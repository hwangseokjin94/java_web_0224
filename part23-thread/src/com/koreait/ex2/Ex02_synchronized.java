package com.koreait.ex2;


// Maker -> Sender


// Maker
class Maker {
	
	// Field
	private String message;
	private boolean isMade = false;
	
	// Method
	public String getMessage() {
		// 메시지가 없는 상태라면 wait() 처리
		if ( !isMade ) {
			try {
				// 동기화 블록 처리 (일부만 동기화 처리)
				synchronized(this) { 
					wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return message;
	}
	public synchronized void setMessage(String message) {  // 메시지 저장의 완전한 완성은 setMessage() 메소드가 끝날때까지 터치하지 않는 것이다. : synchronized
		this.message = message;
		this.isMade = true;  // 메시지가 생성되었다.
		notify();
	}
	
}

// Sender
class Sender extends Thread {
	
	// Field
	private Maker maker;
	
	// Constructor
	public Sender(Maker maker) {
		this.maker = maker;
	}
	
	// Method
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
	
	// Field
	private Maker maker;
	
	// Constructor
	public Reader(Maker maker) {
		this.maker = maker;
	}
	
	// Method
	public void run() {
		System.out.println(maker.getMessage());
		System.out.println("수신 완료");
	}
	
}


public class Ex02_synchronized {

	public static void main(String[] args) {

		
		Maker maker = new Maker();
		
		Sender sender = new Sender(maker);
		Reader reader = new Reader(maker);
		
		sender.start();
		reader.start();
		

	}

}
