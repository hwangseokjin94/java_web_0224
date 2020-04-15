package com.koreait.test1;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {

//Test03.java
//나이를 입력 받아 7 이하이면 "미취학", 13 이하이면 "초등학생", 
//		16 이하이면 "중학생", 19 이하이면 "고등학생", 나머지는 "성인"
//단, 1 ~ 120 이외의 나이를 입력하면 "불가능한 나이" 출력하기

		System.out.println("나이를 입력하세요");
		Scanner sc =new Scanner(System.in);
		int age = sc.nextInt();
		if(age<0||age>120){
			System.out.println("불가능한 나이");
     	}else if(age<=7) {
			System.out.println("미취학");
		}else if(age>=7 && age<=13) {
			System.out.println("초등학생");
		}else if(age>=13 && age<=16) {
			System.out.println("중학생");
		}else if(age>=16 && age<=19) {
			System.out.println("고등학생");
		}else {
			System.out.println("성인");
		}
		
		
		
		
		
		
		sc.close();
	}

}
