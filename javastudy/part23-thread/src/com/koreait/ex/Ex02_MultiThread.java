package com.koreait.ex;

//Gun ->Thread가 되려면 Thread 클래스를 상속한다. 
class Gun extends Thread {
	
	private String model;
	private int bullet ;
	public Gun(String model, int bullet) {
	
		this.model = model;
		this.bullet = bullet;
	} 
	
	@Override
	public void run() { //스레드를 실행하는 메소드
		for(int i  = 0 ; i <bullet ; i++) {
			System.out.println(model+" : "+(i+1)+"발사");
		try {
			sleep(500); //0.5초 멈춤
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}



public class Ex02_MultiThread {

	public static void main(String[] args) {
		Gun gun1 = new Gun("베레타",6);
		Gun gun2 = new Gun("콜트",10);
		
		gun1.start(); //스레드의 시작을 요청하는 start() 메소드
		gun2.start(); //start() 메소드가 호출되면 run()메소드가 실행된다.
		//첫번째작업이끝나기전에 두번째작업시작 각자 시작한다.
		
		System.out.println("main의 종료");
				
	}

}

/*
//Gun
class Gun {
	
	private String model;
	private int bullet ;
	public Gun(String model, int bullet) {
	
		this.model = model;
		this.bullet = bullet;
	} 
	public void shoot() {
		for(int i  = 0 ; i <bullet ; i++) {
			System.out.println(model+" : "+(i+1)+"발사");
		}
	}
}



public class Ex02_MultiThread {

	public static void main(String[] args) {
		Gun gun1 = new Gun("베레타",6);
		Gun gun2 = new Gun("콜트",10);
		
		gun1.shoot();
		gun2.shoot();
				
	}

}
*/
