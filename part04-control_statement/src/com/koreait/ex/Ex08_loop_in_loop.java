package com.koreait.ex;

public class Ex08_loop_in_loop {

	public static void main(String[] args) {
		
		// 구구단
		
		// fix(고정)값을 바깥쪽 loop에 배치
		
		// 1. 세로로 출력
		// 2x1=2
		// 2x2=4
		// 2x3=6
		// 2x4=8
		// 2x5=10
		// 2x6=12
		// 2x7=14
		// 2x8=16
		// 2x9=18
		// 3x1=3
		// 3x2=6
		// 3x3=9
		// 3x4=12
		// ...
		// 9x9=81
		
		for (int dan = 2; dan < 10; dan++) {
			for (int n = 1; n < 10; n++) {
				System.out.println(dan + "x" + n + "=" + (dan*n));
			}
		}
		
		
		// 2. 가로로 출력
		// 2x1=2	3x1=3	...	9x1=9
		// 2x2=4	3x2=6	...	9x2=18
		// 2x3=6	3x3=9	...	9x3=27
		// ...
		// 2x9=18	3x9=27	...	9x9=81
		// print 와 \t 활용
		for (int n = 1; n < 10; n++) {
			for (int dan = 2; dan < 10; dan++) {
				System.out.print(dan + "x" + n + "=" + (dan*n) + "\t");
			}
			System.out.println();  // 줄바꿈
		}

	}

}
