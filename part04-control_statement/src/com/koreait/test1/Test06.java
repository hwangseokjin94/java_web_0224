package com.koreait.test1;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자 입력 >> ");
		char ch = sc.next().charAt(0);
		
		if (ch >= 'A' && ch <= 'Z') {
			System.out.println(ch + "는 대문자");
		} else if (ch >= 'a' && ch <= 'z') {
			System.out.println(ch + "는 소문자");
		} else if (ch >= '0' && ch <= '9') {
			System.out.println(ch + "는 아라비아 숫자");
		} else {
			System.out.println(ch + "는 일반 문자");
		}
		
		sc.close();

	}

}



