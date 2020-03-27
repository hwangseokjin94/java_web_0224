package com.koreait.ex;

import java.util.Arrays;

public class Ex06_bubble_sort {

	public static void main(String[] args) {
		
		// 대부분은 정렬되어 있는 경우 버블소트가 셀렉션소트보다 유리
		
		int[] arr = {1, 2, 3, 4, 5, 9, 8, 7, 6};
		boolean beChanged;  // 앞뒤 교환이 발생한 적이 있는가?
		
		System.out.println( "정렬 전 = " + Arrays.toString(arr) );
		
		for (int i = 0; i < arr.length - 1; i++) {
			
			beChanged = false;  // 아직 비교하기 전이므로 교환된 적이 없다.
			
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {  // 오름차순 : >    내림차순 : <
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					beChanged = true;  // 교환된 적이 있다.
				}
			} // end for j
			
			if ( !beChanged ) {  // 교환된 적이 없다면 (=이미 정렬되어 있다면)
				break;
			}
			
		}  // end for i

		System.out.println( "정렬 후 = " + Arrays.toString(arr) );
		
	}

}
