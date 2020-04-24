package com.koreait.ex;

class LegacyOmniBox {
	Object obj ;

	public LegacyOmniBox(Object obj) {
		
		this.obj = obj;
	}



	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	
}
//담을물건
class Computer {
	
}

class SmartPhone{
	
}

public class Ex01_LegacyOmniBox {
	public static void main(String[] args) {
		LegacyOmniBox box = new LegacyOmniBox(new Computer());
		
//		Computer myCom = box.getObj(); //geObj()리턴 타입은 Object 타입은 적절한 형변환
		Computer myCom = (Computer)box.getObj(); //geObj()리턴 타입은 Object 타입은 적절한 형변환
		System.out.println(myCom);
		box.setObj(new SmartPhone());
		SmartPhone myPhone =(SmartPhone)box.getObj();
		System.out.println(myPhone);
		
		
		//잘못된케스팅
		box.setObj(new Computer());		// box.setObj(new SmartPhone());스마트폰을설정할라햇는데 컴퓨터로 설정을함.
		SmartPhone yourPhone =(SmartPhone)box.getObj();//ClassCastException
		System.out.println(yourPhone);
		
		//object를 이용해서 저장하면
		//항상 캐스팅을 해야하는데
		//실수로 캐스팅을 잘못해도 "자바는 모른다."(오류가 체크되지않는다)
		
		
	}
}
