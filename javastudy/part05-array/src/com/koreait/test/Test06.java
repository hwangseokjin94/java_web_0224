package com.koreait.test;

public class Test06 {

	public static void main(String[] args) {
		
		int[] arr = new int[100];
		int[] counter = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10);
		}
		
		for (int i = 0; i < arr.length; i++) {
			// 생성된 랜덤 값 == arr[i]
			counter[ arr[i] ]++;
		}
		
		for (int i = 0; i < counter.length; i++) {
			String graph = "";
			for (int j = 0; j < counter[i]; j++) {
				graph += "#";
			}
			System.out.println(i + "의 개수 = " + graph + " " + counter[i]);
		}

	}

}