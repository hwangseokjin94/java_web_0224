package com.koreait.test;

public class Test04 {

	public static void lotto1() {
		// 방법1.
		// 1. 45개 ball 을 순차적으로 생성한다.
		// 2. 첫 7개 데이터를 다른 임의의 인덱스 값과 교환한다.
		int[] ball = new int[45];
		
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}
		
		int tmp = 0;
		int j = 0;
		for (int i = 0; i < 7; i++) {
			j = (int)(Math.random() * 45);  // 0 ~ 44 사이 발생
			tmp = ball[i];
			ball[i] = ball[j];
			ball[j] = tmp;
		}
		
		System.out.print("이번 주 당첨번호 : [");
		for (int i = 0; i < 6; i++) {
			System.out.print(ball[i]);
			if (i < 5) {
				System.out.print(", ");
			} else {
				System.out.print("]");
			}
		}
		System.out.println("\n보너스번호 : " + ball[6]);
	}
	
	public static void lotto2() {
		// 방법2.
		// 1. 45개 ball 을 순차적으로 생성한다.
		// 2. 임의의 인덱스 값을 발생시켜 pick 배열에 해당 인덱스 값을 저장한다.
		// 3. 마지막 데이터를 빼낸 자리로 이동한다.
		// 4. 배열의 검색 범위를 줄인다.
		int ballCount = 45;
		int[] ball = new int[ballCount];
		int[] pick = new int[7];
		
		// 1. 1 ~ 45 순차 생성
		for (int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}
		
		// 2. ball 에서 7개를 pick 으로 저장
		for (int i = 0; i < pick.length; i++) {
			int j = (int)(Math.random() * ballCount);
			pick[i] = ball[j];
			int lastIndex = 44 - i;
			if (j != lastIndex) {
				ball[j] = ball[lastIndex];
			}
			ballCount--;
		}
		// 3. 출력
		System.out.print("이번 주 당첨번호 : [");
		for (int i = 0; i < 6; i++) {
			System.out.print(pick[i]);
			if (i < 5) {
				System.out.print(", ");
			} else {
				System.out.print("]");
			}
		}
		System.out.println("\n보너스번호 : " + pick[6]);
		
	}
	
	public static void main(String[] args) {
		lotto1();
		System.out.println("---------------------------");
		lotto2();
	}

}
