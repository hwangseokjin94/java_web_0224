package com.koerait.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Car
class Car{
	//field
	private String carNo;
	private String owner;
	
	//Constructor
	public Car(String carNo, String owner) {
		this.carNo =carNo;
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return carNo+"("+owner+")";
	}
	//중복된 Car객체의 체크를하려면
	//hashCode()+equals()메소드를 모두 오버라이드를 해야한다.
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carNo == null) ? 0 : carNo.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;}
		if(obj instanceof Car){
			Car other = (Car) obj;
			return carNo.equals(other.carNo);
		}
		return false;
			}
	
	
}



public class Ex04_HashMap {

	public static void main(String[] args) {
	
		//주차장 상황
		//key : Car (중복발생 금지)
		//value: fee(요금은 중복상관없음)
		
		Map<Car, Integer> parkingLot = new HashMap<Car, Integer>();
		parkingLot.put(new Car("20가1234","앨리스"), 3000);
		parkingLot.put(new Car("20가1234","앨리스"), 5000); //앨리스의 요금이 5000원으로 갱신되었다.
		
		Set<Car> set =parkingLot.keySet();
		Iterator<Car> itr = set.iterator();
		while(itr.hasNext()) {
			
			Car car = itr.next();
			Integer fee = parkingLot.get(car);
			System.out.println(car+"의 요금 :"+fee+"원");
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
