package com.koreait.ex;

public class Ex09_label {

	public static void main(String[] args) {
		
		// 구구단
		
		// 세로로 출력
		// 4x4=16 까지만 출력하기
		
		int n;
		for (int dan = 2; dan < 10; dan++) {
			for (n = 1; n < 10; n++) {
				System.out.println(dan + "x" + n + "=" + (dan*n));
				if (dan == 4 && n == 4) {
					break;
				}
			}
			if (dan == 4 && n == 4) {
				break;
			}
		}

		
		// label : 소스 코드의 특정 위치를 지정하는 방법
		// 사용방법
		// 레이블명:
		
		outer:  // outer 레이블 생성
		for (int dan = 2; dan < 10; dan++) {
			inner:  // inner 레이블 생성
			for (n = 1; n < 10; n++) {
				System.out.println(dan + "x" + n + "=" + (dan*n));
				if (dan == 4 && n == 4) {
					// break inner;  // 기존 break;
					break outer;  // outer 레이블의 종료
				}
			}
		}
		
	}

}
