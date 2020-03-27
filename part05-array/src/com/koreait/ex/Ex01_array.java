package com.koreait.ex;

public class Ex01_array {

	public static void main(String[] args) {
		
		/*
		 * 배열 (Array)
		 * 
		 *  1. 선언 방법
		 *     1) int[] arr = new int[3];  // 추천
		 *     2) int arr[] = new int[3];
		 *     3) int[] arr;  // 참조변수 arr 선언 (arr에는 주소를 저장할 수 있다.)
		 *        arr = new int[3];  // int 변수를 3개 생성하고 그 주소를 arr 에 저장
		 *  2. 초기화 방법
		 *     1) int[] arr = new int[]{10, 20, 30};
		 *     2) int[] arr = {10, 20, 30};  // 추천
		 *     3) int[] arr;
		 *        arr = {10, 20, 30};  // 불가능한 초기화 방식(선언 시점에서만 가능)
		 *  3. 주요 특징
		 *     1) 배열의 인덱스는 0부터 시작한다.
		 *     2) 배열이 생성되면 자동으로 0으로 초기화된다.
		 *     3) 배열이 생성되면 배열의 길이를 가지고 있는 length 필드 값을 사용할 수 있다.
		 *     4) 배열의 인덱스 사용 범위를 벗어나면 ArrayIndexOutOfBoundsException 예외가 발생한다.
		 */
		
		
		int[] arr1 = new int[3];  // 모든 요소가 0으로 초기화된다.
		int[] arr2 = {10, 20, 30};
		
		System.out.println("arr1의 길이 = " + arr1.length);
		System.out.println("arr2의 길이 = " + arr2.length);
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		System.out.println(arr1[3]);  // 인덱스 범위를 벗어난 요소

	}

}
