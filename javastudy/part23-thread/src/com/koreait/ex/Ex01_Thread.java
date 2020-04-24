
package com.koreait.ex;

//스레드 생성
class ThreadTask extends Thread {
	// 스레드를 상속하면 스레드이다.
	private String taskName;

	public ThreadTask(String taskName) {
		this.taskName = taskName;

	}

	// Method
	@Override
	public void run() {

		try {
			sleep(1000);// 1초
			System.out.println(taskName);
			sleep(1000);// 1초
			System.out.println(taskName);
			sleep(1000);// 1초
			System.out.println(taskName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class Ex01_Thread {
	public static void main(String[] args) {
	   Thread thread = new ThreadTask("나의 첫 스레드 ");
	   thread.start();                                  
	   System.out.println("main 쓰레드는 종료됩니다.");
	   
	}
}
