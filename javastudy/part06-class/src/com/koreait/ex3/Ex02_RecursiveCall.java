package com.koreait.ex3;

public class Ex02_RecursiveCall {

	static void recursive(int count) {
		if (count == 0) {
			return;
		} else {
			System.out.println(count + "번째 호출");
			recursive(count - 1);
		}
	}
	
	public static void main(String[] args) {
		recursive(10);  // 10번 반복하고 종료
	}

}
