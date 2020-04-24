package com.koreait.ex;

//PriorityThread
class PriorityThread extends Thread {
	// Constructor
	public PriorityThread(String name) {
		setName(name);

	}

	// method
	@Override
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("PriorityThread의 이름 : "+ getName());
	}
}

public class Ex05_priority {
	public static void main(String[] args) {

		System.out.println("가장낮은 우선순위 : " + Thread.MIN_PRIORITY);
		System.out.println("중간 우선 순위" + Thread.NORM_PRIORITY);
		System.out.println("가장 높은 우선 숭위 :" + Thread.MAX_PRIORITY);
		
		//PriorityThread객체생성
		for(int i  =  0 ;  i  <10 ; i++) {
			Thread task  = new PriorityThread("PriorityThread-"+(i+1));
			//각 task에 서로다른 우선순위를 부여
			if(i < 3) { //초반 3개
				task.setPriority(Thread.MAX_PRIORITY);//먼저실행되도록 높은 우선순위를 부여한다.
				
			}else if (i<8) {//중간 4개
				task.setPriority(Thread.NORM_PRIORITY);
			}else {//마지막3개
				task.setPriority(Thread.MIN_PRIORITY);//나중에실행되도록 낮은 우선순위를 부여한다.
			}
			
			task.start();
		}

	}
}

