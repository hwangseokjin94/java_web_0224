package com.koreait.test2;

import java.util.Random;

public class Test10 {

	public static void main(String[] args) {
		/*Test10.java
		10000원 모두 사용하기
		사용할 돈은 난수로 임의 발생
		가진 돈을 모두 사용할때까지 반복하기
		실행 예)
		현재 10000원이 있습니다.
		7867원 사용합니다. 남은 돈은 2133원입니다.
		1775원 사용합니다. 남은 돈은 358원입니다.
		98원 사용합니다. 남은 돈은 260원입니다.
		135원 사용합니다. 남은 돈은 125원입니다.
		40원 사용합니다. 남은 돈은 85원입니다.
		69원 사용합니다. 남은 돈은 16원입니다.
		13원 사용합니다. 남은 돈은 3원입니다.
		1원 사용합니다. 남은 돈은 2원입니다.
		0원 사용합니다. 남은 돈은 2원입니다.
		0원 사용합니다. 남은 돈은 2원입니다.
		0원 사용합니다. 남은 돈은 2원입니다.
		1원 사용합니다. 남은 돈은 1원입니다.
		1원 사용합니다. 남은 돈은 0원입니다. */
/*
		int money =7867;
		double a = Math.random()*100000;
		System.out.println((int)a);
		int leavMoney=0;
		if(money/5000!=0) {
			System.out.print(money+"사용합니다");
			leavMoney = money%5000;
			System.out.println("남은돈은"+leavMoney+"입니다");
			if(leavMoney/1000!=0){
				System.out.print(leavMoney+"사용합니다");
			    leavMoney = money%1000;
			System.out.println("남은돈은"+leavMoney+"입니다");
				if(leavMoney/500!=0){
					System.out.print(leavMoney+"사용합니다");
				    leavMoney = money%500;
				System.out.println("남은돈은"+leavMoney+"입니다");
					if(leavMoney/100!=0){
						System.out.print(leavMoney+"사용합니다");
					    leavMoney = money%100;
					System.out.println("남은돈은"+leavMoney+"입니다");
						if(leavMoney/50!=0){
							System.out.print(leavMoney+"사용합니다");
						    leavMoney = money%50;
						System.out.println("남은돈은"+leavMoney+"입니다");
							if(leavMoney/10!=0){
								System.out.print(leavMoney+"사용합니다");
							    leavMoney = money%10;
							System.out.println("남은돈은"+leavMoney+"입니다");
							}
						}
					}
				}			
			}
		}
*/
		
		Random rand = new Random();
		int money = 10000;
		System.out.println("현재 " + money+"원이 있습니다.");
		
		while(true) {
			int n = rand.nextInt(money+1);//0~money사이의 수가 발생한다.
		System.out.println(n+"원 사용합니다.. 남은돈은"+(money-=n)+"원 입니다.");
		if(money == 0) {
			break;
		}
			
		}
		
		
	}

}
