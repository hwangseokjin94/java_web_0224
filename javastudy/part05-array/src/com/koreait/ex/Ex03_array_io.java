package com.koreait.ex;

import java.util.Arrays;
import java.util.Scanner;

public class Ex03_array_io {

	public static void main(String[] args) {
		
		// 사용자로부터 생성할 배열의 길이를 입력 받아서 해당 배열을 생성하고,
		// 생성된 배열에 임의의 값을 입력 받고, 출력하기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("생성할 배열의 길이는? >> ");
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		
		
		// 1. 입력
		for (int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + "번째 입력 >> ");
			arr[i] = sc.nextInt();
		}
		
		// 2. 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// 3. arr 의 출력값은?  참조값(배열 요소들이 저장된 주소값)
		System.out.println(arr);
		
		// 4. 배열의 요소를 출력하는 메소드
		System.out.println( Arrays.toString(arr) );
		
		sc.close();
		
	}
	
}
