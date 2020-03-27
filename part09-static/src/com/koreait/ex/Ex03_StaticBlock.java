package com.koreait.ex;

import java.util.Arrays;

public class Ex03_StaticBlock {

	// static 필드
	static int a;
	static int[] arr = new int[10];
	
	// static 블록 (초기화) : static 필드의 초기화 작업
	static {
		a = 10;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 101);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(a);
		System.out.println(Arrays.toString(arr));

	}

}
