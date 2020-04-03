package com.koreait.ex2;


// Cleaner
class Cleaner {
	
	// synchronized
	// 임계 영역 : Critical Section
	// 공유 리소스(Cleaner)를 다루는 영역 중에서 한 번에 한 스레드만 접근해야 하는 영역
	// 동기화 메소드(동기화 블록)으로 처리한다.
	// 동기화 처리 : 한 스레드가 사용하는 중에는 다른 스레드의 접근을 막는 처리
	// 메소드 앞에 synchronized 추가
	
	public synchronized void diningRoomCleaning() {
		try {
			System.out.println("다이닝 룸 청소 중...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("다이닝 룸 청소 완료!");
		notify();  // Object 클래스의 메소드 (다이닝 룸 청소가 끝났음을 다른 스레드(Papa)에게 알려라.)
		try {
			System.out.println("거실 청소 완료까지 기다림!");
			wait();  // 나는 (Mama) 기다리겠다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void livingRoomCleaning() {
		try {
			System.out.println("거실 청소 중...");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("거실 청소 완료!");
		notify();//wait()상태(블록상태)를 풀어준다.
		try {
			System.out.println("다이닝 룸 청소 완료까지 기다림!");
			wait();//notify()가 호출 될때까지 wait()상태(블록상태)가 된다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}


// Papa
class Papa extends Thread {
	
	// Field
	private Cleaner cleaner;
	
	// Method
	public void setCleaner(Cleaner cleaner) {
		this.cleaner = cleaner;
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			cleaner.livingRoomCleaning();
		}
	}
	
}


// Mama
class Mama extends Thread {
	
	// Field
	private Cleaner cleaner;
	
	// Method
	public void setCleaner(Cleaner cleaner) {
		this.cleaner = cleaner;
	}
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			cleaner.diningRoomCleaning();
		}
	}
	
}


public class Ex01_synchronized {

	public static void main(String[] args) {
		
		
		Cleaner cleaner = new Cleaner();
		
		Papa papa = new Papa();  // papa : 스레드
		Mama mama = new Mama();  // mama : 스레드
		
		papa.setCleaner(cleaner);
		mama.setCleaner(cleaner);
		
		papa.start();  // run() -> cleaner.livingRoomCleanging() 호출, synchronized 처리로 메소드 종료까지 cleaner 를 뺏기지 않는다.
		mama.start();

		
	}

}









