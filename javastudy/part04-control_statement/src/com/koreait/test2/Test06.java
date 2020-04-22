package com.koreait.test2;

import java.util.Random;
import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
/*Up-Down 게임
1 ~ 100 사이에서 임의의 숫자(난수)를 하나 발생시킨 뒤
해당 숫자를 맞추는 게임
입력 받은 숫자의 크기에 따라 "Up!", "Down!", "Answer!" 로 나눠서 출력하고
맞출때까지 몇 번 진행했는지 횟수도 함께 출력
실행 예)
입력 >> 30
Up!
입력 >> 40
Down!
입력 >> 35
Down!
입력 >> 33
Answer!
총 4회만에 성공!
 * */
		 Scanner sc =new Scanner(System.in);
		 Random rand = new Random();// 난수를 발생할수 있는 rand 객체 생성
		 int answer= rand.nextInt(100)+1;//발생한난수
		 int guess=0;//사용자 입력값
		 int count=0;//카운팅 변수
		 
		 do {
			 System.out.print("1~100사이 정수입력>>>>");
			 guess=sc.nextInt();
			 count++;
			 if(guess<answer) {
				 System.out.println("up!");
			 }else if(guess>answer) {
				 System.out.println("down!");
			 }else {
				 System.out.println("Answer!");
				 System.out.println("총 "+count+"회만에 성공");
				 break;
			 }
		 }while(answer!=guess);
		 
		 sc.close();
	}

}
