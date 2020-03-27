package com.itkoreaex;

//인터페이스 
interface Computable {
	public void playApp();

	public void connectInternet();

}

//부모 (슈퍼)
class Phone {
	// field
	private String owner;

	// Constructor
	public Phone(String owner) {
		this.owner = owner;
	}

	public void sendCall() {
		System.out.println(owner + "의 전화걸기");
	}

	public void receiveCall() {
		System.out.println(owner + "의 전화받기");
	}

}


//상속과 구현을 동시에 진행
//상속 먼저 구현나중
//자식 + 구현
class SmartPhone extends Phone implements Computable{

	// Constructor (Phone의 생성자를 호출하기 위함.)
	public SmartPhone(String owner) {
		super(owner);
	}
	//Method
	@Override
	public void playApp(){
		System.out.println("앱 실행");
	}
	@Override
	public void connectInternet() {
		System.out.println("인터넷접속");
	}
	
	
	
	
}





public class Ex05_Computable {

	public static void main(String[] args) {
		//1.Phone 타입
		Phone phone1 = new SmartPhone("앨리스");
		phone1.sendCall();
		phone1.receiveCall();
		((Computable)phone1).playApp();
		((Computable)phone1).connectInternet();
		
		
		//2. Computable타입
		Computable phone2 = new SmartPhone("제임스");
		((Phone)phone2).sendCall();
		((Phone)phone2).receiveCall();
		phone2.playApp();
		phone2.connectInternet();
		
		
		//3. smartphone타입
		SmartPhone phone3 = new SmartPhone("데이빗");
		phone3.connectInternet();
		phone3.playApp();
		phone3.receiveCall();
		phone3.sendCall();
		

	}

}
