package com.koreait.ex;

public class Ex05_generic_method {
	// 정수타입(Integer) /실수타입(Double)의 배열을 파라미터로 받아서
	// 해당배열의 모든 숫자의 합을 구해서 리턴하는 메소드.

	// Integer와 Double의 부모타입으로Number 클래스가 있다.
	// Number 타입은 Integer ,Double의 저장용으로 사용할수있다.
	public static <T extends Number> double getArrayTotal(T[] arr) {
		// <T> : 모든 타입이 가능
		// <T extends Number> : Number 타입만 가능

		double total = 0;
		for (int i = 0; i < arr.length; i++) {
			// arr[i]:  reference type 은 객체이므로 메소드가 있다.
			total += arr[i].doubleValue(); 
		}
		return total;
	}

	public static void main(String[] args) {
		//Stirng[] 배열은 getArrayTotal()메소드에 전달할수없다.
		//<T extends Number>에 의해 Number 클래스의 자식클래스만 전달할수 있기 떄문이다.
		//String[] a = {"가위","바위","보"};
		//getArryTotal(a);
		
		//Integer[]배열
		Integer[] arr1 = {1,2,3,4,5};
		double total1 = getArrayTotal(arr1);
		System.out.println("arr1의 합 : "+total1);
		
		//Double[]배열
		Double[] arr2 = {1.23,1.56,6.95,7.65};
		double total2 = getArrayTotal(arr2);
		System.out.println("arr2의 합 : "+total2);
		
		
		
		
	}
}
