package com.koreait.ex;

public class Ex04_generic_method {

	// 무엇이든 배열을 출력할 수있는 printArray() 메소드 정의
	// [1,2,3,4,5]
	// ["가위","바위","보"]

	/*
	 * 메소드 오버로딩 (같은 이름 +다른맥개변수)으로 해결할수있다. public static void printArray(int[] arr)
	 * {} public static void printArray(String[] arr) {} public static void
	 * printArray(double[] arr) {} public static void printArray(long[] arr) {}
	 * public static void printArray(char[] arr) {} ...
	 */

	// generic 으로 처리하기 (제네릭 메소드)
	public static <T> void printArray(T[] arr) { // 메소드시작앞에 <T>붙이기
		System.out.print("[");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length - 1] + "]");
	}

	public static void main(String[] args) {

//		int[] arr1 = {1,2,3,4,5};
		// 안되는 이유는 제네릭에특성때문이다. 제네릭타입은 참조타입만가능하다.....int,double 등은 전달못함...
		// primitive type 이 불가능하다. reference type 만가능하다.
		// 그럼 어디를 수정을 해야할까요? >>int를 Integer로수정하면된다
		Integer[] arr1 = { 1, 2, 3, 4, 5 };
		printArray(arr1);

		String[] arr2 = { "홍길동", "엘리스", "코로나" }; // String 타입이 reference type 임.
		printArray(arr2);

		Double[] arr3 = { 1.5, 3.5, 2.78 };
		printArray(arr3);

	}
}
