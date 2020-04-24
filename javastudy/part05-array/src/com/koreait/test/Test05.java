package com.koreait.test;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final String[] GBB = {"가위", "바위", "보"};  // GBB[0] == "가위",  GBB[1] == "바위",  GBB[2] == "보"
		int win = 0;
		int draw = 0;
		
		game:
		while (true) {
			int comIndex = (int)(Math.random() * 3);
			int userIndex = 999999;
			System.out.print("가위 바위 보 >> ");
			String user = sc.next();
			for (int i = 0; i < GBB.length; i++) {
				if (user.equals(GBB[i])) {
					userIndex = i;
				}
			}
			if (userIndex == 999999) {
				System.out.println("다시 입력하세요.");
				continue;
			}
			System.out.print("컴퓨터는 " + GBB[comIndex] + ", 당신은 " + GBB[userIndex] + ", ");
			
			// userIndex - comIndex		이겼다.	비겼다.	졌다.
			// 가위						-2		0		-1
			// 바위						1		0		-1
			// 보						1		0		2
			
			switch (userIndex - comIndex) {
			case -2:
			case 1:
				System.out.println("이겼다.");
				win++;
				break;  // switch 종료
			case 0:
				System.out.println("비겼다.");
				draw++;
				break;  // switch 종료
			default:
				System.out.println("졌다.");
				System.out.println(win + "승 " + draw + "무 달성!");
				break game;  // game 레이블 종료(while 문 종료)
			}
			
		}
		
		sc.close();

	}

}
