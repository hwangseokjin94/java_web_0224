package com.koreait.test;

import java.util.Scanner;

public class Test07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. 랜덤 생성 3개
        int[] com = new int[3];
        com[0] = (int) (Math.random() * 10);
        do {
            com[1] = (int) (Math.random() * 10);
        } while (com[0] == com[1]);
        do {
            com[2] = (int) (Math.random() * 10);
        } while (com[0] == com[2] || com[1] == com[2]);

        // 2. 사용자 게임 시작
        int[] user = new int[3];
        int strike = 0;
        int ball = 0;
        int count = 0;
        do {
            count++;
            System.out.print("도전 >> ");
            int userSize = user.length;
            for (int i = 0; i < userSize; i++) {
            	user[i] = sc.nextInt();
            }
            // strike
            strike = 0;
            int comSize = com.length;
            for (int i = 0; i < comSize; i++) {
                if (com[i] == user[i]) {
                    strike++;
                }
            }
            // ball
            ball = 0;
            for (int i = 0; i < com.length; i++) {
                for (int j = 0; j < user.length; j++) {
                    if (com[i] == user[j] && i != j) {
                        ball++;
                    }
                }
            }
            // 결과 출력
            System.out.println(strike + "스트라이크, " + ball + "볼");
        } while (strike != 3);

        System.out.println(count + "번만에 성공!");

        sc.close();

    }

}
