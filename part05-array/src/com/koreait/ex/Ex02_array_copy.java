package com.koreait.ex;

public class Ex02_array_copy {

	public static void main(String[] args) {
		
		/*
		 * 배열의 길이
		 *  1. 배열의 길이는 length 필드 값을 확인한다.
		 *  2. 배열의 선언 시 배열의 길이는 변수로 처리할 수 있다.
		 *  3. 한 번 생성된 배열의 길이는 변경할 수 없다.
		 *     -> 기존 배열의 크기를 변경할 수 없다.
		 *  4. 기존 배열의 크기를 늘이려면 큰 배열을 새로 만들고, 기존 배열을 복사한다.
		 */
		
		int[] arr = {10, 20, 30, 40, 50};
		int[] tmp = new int[arr.length * 2];
		
		System.out.println("변경 전 arr의 길이 = " + arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// 1. arr -> tmp 복사
		for (int i = 0; i < arr.length; i++) {
			tmp[i] = arr[i];
		}
		
		// 2. arr -> tmp 복사
		// System.arraycopy(arr, 0, tmp, 0, arr.length);  // arr[0]에서 tmp[0]로 복사시작, arr.length만큼 진행
		
		// 3. tmp 정보를 arr 가 가져가야 함
		arr = tmp;
		
		System.out.println("변경 후 arr의 길이 = " + arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

}
