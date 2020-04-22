package com.koreait.ex;
//RunnableImpl
class RunnableImpl implements Runnable{
	@Override
	public void run() {
		while(true) { //1초마다 자기이름을 보여준다.
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}
	}
}

public class Ex08_stop {

	public static void main(String[] args) {
		Runnable runThread = new RunnableImpl();
		Thread thread1 = new Thread(runThread,"앨리스");
		Thread thread2 = new Thread(runThread,"제임스");
		
		thread1.start();
		thread2.start();
		
		try {
			Thread.sleep(5000);
//			thread1.suspend();//잠시멈춤(비사용을 추천)
//			thread1.resume();//다시시작 (비사용을 추천)
			thread1.stop(); //완전중지
			thread2.stop();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
