package com.itkoreaex;

interface Providable {
	public void sightseeing(); // 관광 public abstract void sightseeing();

	public void leisure();// 레저

	public void food();// 음식

}

class KoreaTour implements Providable {
//반드시 인터페이스 Providable의 "모든메소드를 "오버라이드를 해야한다.
	@Override
	public void sightseeing() {
		System.out.println("광화문 관광");
	}

	@Override
	public void leisure() {
		System.out.println("한강 유람선");
	}

	@Override
	public void food() {
		System.out.println("불고기");
	}

}
class GuamTour implements Providable{

	@Override
	public void sightseeing() {
	System.out.println("투몬비치");
		
	}

	@Override
	public void leisure() {
		System.out.println("패들보트");
		
	}

	@Override
	public void food() {
		System.out.println("피자");
		
	}
	
}
//데이터클래스
class TourGuid{
	//private KoreaTour tour ;  //한국여행이 가능한가이드
	//private GuamTour tour;//괌을 여행가능한가이드	
	private Providable tour ; // 한국,관ㅁ 여행이 모두가능한가이드
	
	public TourGuid(Providable tour) {
		this.tour = tour;
	}
	public void sightseeing() {
		tour.sightseeing(); //다형성 (전달된 tour에따라 동작이 다라진다.
	}
	public void lesisure() {
		tour.leisure();
	}
	public void food() {
		tour.food();
	}
	
	
}

public class Ex04_Providable {
	public static void main(String[] args) {
		GuamTour tour = new GuamTour();
		//KoreaTour tour = new KoreaTour();
		TourGuid guid = new TourGuid(tour);
		
		guid.sightseeing();
		guid.lesisure();
		guid.food();
	}
}
