package com.koreait.test1;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		// TTest07.java
//		알파벳을 하나 입력 받아 대문자가 입력되면 소문자로 변환해서 출력하고,
//		소문자가 입력되면 대문자로 변환해서 출력하고, 나머지 문자들은 입력된 그대로 출력하기

		
		Scanner sc =new Scanner(System.in);
		System.out.println("알파벳을 입력하세요");
		char tmpCh1 = 'A';
		char tmpCh2 = 'a';
		
		System.out.println("알파벳 A 의코드값:"+(int)tmpCh1);
		System.out.println("알파벳 a 의코드값:"+(int)tmpCh2); //32 코드값 차이가 난다.
		char ch = sc.next().charAt(0);
		if(ch >='A' && ch <='Z') {
			System.out.println(ch+=32);
		}else if (ch >= 'a' && ch <='z') {
			System.out.println(ch-=32);			
		}else {		
			System.out.println(ch);
		}
		sc.close();
	}

	}


