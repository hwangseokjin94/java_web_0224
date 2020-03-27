package com.koreait.test2;

public class Test03 {

	public static void main(String[] args) {
		
		int total = 0;  // 합계
		int start = 1;
		int end = 100;
		int unitsDigit = 0;  // 일의자리
		
		for (int n = start; n < end + 1; n++) {
			// 일의자리 추출
			unitsDigit = n % 10;
			if (unitsDigit % 3 == 0 && unitsDigit != 0) {
				total += n;
			}
		}
		
		System.out.println(start + " ~ " + end + " 사이 일의자리가 3의 배수인 정수의 합 = " + total);

	}

}
