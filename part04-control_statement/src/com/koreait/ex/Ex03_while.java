package com.koreait.ex;

import java.util.Scanner;

public class Ex03_while {

	public static void main(String[] args) {
		//0~9출력
		int a = 0 ;//초기문
		while(a<10) {// 조건문(종료문 )
			System.out.println(a);
			a++;//증감문
			
		}
     //2. 9~0
		int b=9;
				while(b>0){
					System.out.println(b);
					b--;
			
		}
	//3. 'A'~'z'			
				char ch='A';
				while(ch <='Z'){
					System.out.println(ch);
					ch++;
			
		}	
	//4."admin"아이디가 입력 될때까지계속입력받기
	//몇번만에 입력되었는지 출력하기
				
				Scanner sc = new Scanner(System.in);
				int d=0;
			
//				String userId = null;//string의초기화해야됨
				String userId ="";
				while(!userId.equals("admin")) {
					System.out.println("아이디를 입력해주세여");
				    userId = sc.next();	
					d++;
				}	System.out.println(d+"번만에 맞췄습니다.");
				
				
				
				
				
				
	}

}
