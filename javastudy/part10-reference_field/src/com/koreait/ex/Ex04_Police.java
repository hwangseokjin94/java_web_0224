package com.koreait.ex;

// 데이터클래스 Gun
class Gun {
	
	// Field
	String model;
	int bullet;
	final int FULL_BULLET = 6;
	
	// Constructor
	Gun(String model, int bullet) {
		this.model = model;
		if (bullet > FULL_BULLET) {
			this.bullet = FULL_BULLET;
		} else {
			this.bullet = bullet;
		}
	}
	
	// Method
	void shoot() {
		if (bullet > 0) {
			bullet--;
			System.out.println(model + " 빵! " + bullet + "발 남았다.");
		} else {
			System.out.println(model + " 헛빵!");
		}
	}
	void reload(int bullet) {
		this.bullet += bullet;
		if (this.bullet > FULL_BULLET) {
			this.bullet = FULL_BULLET;
		}
		System.out.println(model + "에 " + this.bullet + "발 장전되었다.");
	}
	void printGun() {
		System.out.println(model + "(" + bullet + ")");
	}
	
}

// 데이터클래스 Police
class Police {
	
	// Field
	String name;
	Gun gun;  // null 초기화
	
	// Constructor
	Police(String name, int bullet) {
		this.name = name;
		gun = new Gun("콜트", bullet);
	}
	Police(String name, Gun gun) {
		this.name = name;
		this.gun = gun;
	}
	
	// Method
	void shoot() {
		gun.shoot();
	}
	void reload(int bullet) {
		gun.reload(bullet);
	}
	void printPolice() {
		System.out.println("경찰이름 : " + name);
		gun.printGun();
	}
	
}

// 메인클래스
public class Ex04_Police {

	public static void main(String[] args) {
		
		Police cop1 = new Police("김경찰", 6);
		cop1.printPolice();  // 이름, 총 모델, 총알
		cop1.shoot();
		cop1.shoot();
		cop1.printPolice();  // 이름, 총 모델, 총알
		cop1.reload(5);
		cop1.printPolice();  // 이름, 총 모델, 총알
		
		Gun gun = new Gun("베레타", 6);
		Police cop2 = new Police("이경찰", gun);
		cop2.printPolice();  // 이름, 총 모델, 총알
		cop2.shoot();
		cop2.shoot();
		cop2.printPolice();  // 이름, 총 모델, 총알
		cop2.reload(5);
		cop2.printPolice();  // 이름, 총 모델, 총알
		
	}

}
