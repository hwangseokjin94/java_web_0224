package com.koreait.test1;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char tmpCh1 = 'A';  // 코드값 : 65
		char tmpCh2 = 'a';  // 코드값 : 97
		
		System.out.println("알파벳 A의 코드값 : " + (int)tmpCh1);
		System.out.println("알파벳 a의 코드값 : " + (int)tmpCh2);
		
		System.out.print("알파벳 입력 >> ");
		char ch = sc.next().charAt(0);
		
		if (ch >= 'A' && ch <= 'Z') {
			System.out.println(ch += 32);
		} else if (ch >= 'a' && ch <= 'z') {
			System.out.println(ch -= 32);
		} else {
			System.out.println(ch);
		}
		
		sc.close();

	}

}



