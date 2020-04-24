package com.koreait.ex;

import java.util.Scanner;

public class Ex07_continue {

	public static void main(String[] args) {
		// continue : 반복에서 제외하고 싶은 데이터를 처리할때
		//1. 1~20사이에서 3의 배수를 제외하고 출력
		for(int a= 1;a<21;a++) {
			if(a%3==0) {
				continue;
			}
			System.out.print(a+ " " );
			
		}
		System.out.println();
		int b= 0;
		while(b<21) {
			b++;
		
			if(b%3==0) {
				continue;
			}
			System.out.print(b+ " " );
		
		}
		System.out.println();
	   //3.애들밥먹이기
	   //"굴"빼고 모두잘먹는아이
	  //어떤반찬이든 5번만먹게처리
		Scanner sc =  new Scanner(System.in);
		int count = 0 ;
		String food = "";
		while(count<5) {
			System.out.print("어떤반찬줄까?.>>>>");
			food=sc.next();
			if(food.equals("굴")) {
				System.out.println("굴은싫어요");
				continue;
			}
			System.out.println(food+"잘먹겠습니다.");
			System.out.println("또주세요");
			count++;
		}
		
		
		
		
	}//main

}
