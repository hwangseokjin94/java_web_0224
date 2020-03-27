package com.koreait.ex;

import java.util.Arrays;

public class Ex05_selection_sort {

	public static void main(String[] args) {
		
		int[] arr = {4, 2, 1, 3};
		
		System.out.println( "정렬 전 = " + Arrays.toString(arr) );
		
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {  // 오름차순 : >    내림차순 : <
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		System.out.println( "정렬 후 = " + Arrays.toString(arr) );

	}

}
