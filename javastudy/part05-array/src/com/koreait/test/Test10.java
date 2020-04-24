package com.koreait.test;

import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		
		String[][] dictionary = {
				{"봄", "spring"},
				{"여름", "summer"},
				{"가을", "fall"},
				{"겨울", "winter"}
		};
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < dictionary.length; i++) {
			System.out.print("질문" + (i + 1) + ". " + dictionary[i][0] + "을 영어로 하면? >> ");
			String answer = sc.next();
			if (answer.equalsIgnoreCase(dictionary[i][1])) {
				System.out.println("정답");
			} else {
				System.out.println("오답");
			}
		}
		
		sc.close();

	}

}
