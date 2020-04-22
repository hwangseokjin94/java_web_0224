package com.koreait.ex;

import java.util.Scanner;

public class Ex04_for_each {

	public static void main(String[] args) {
		
		String[] friends = {"앨리스", "제임스", "데이빗"};
		
		// 1. 일반 for 문
		for (int i = 0; i < friends.length; i++) {
			System.out.print(friends[i] + " ");
		}
		System.out.println();
		
		// 2. 향상 for 문 (for each)
		for (String friend : friends) {  // friends 배열의 모든 요소를 하나씩 String friend 변수로 옮겨서 처리
			System.out.print(friend + " ");
		}
		
		
		// 길이가 3인 hobbies 배열을 선언하고,
		// 사용자로부터 취미를 3개 입력 받아 hobbies 배열에 저장 후 출력하기
		
		Scanner sc = new Scanner(System.in);
		String[] hobbies = new String[3];
		
		// 1. 입력
		for (int i = 0; i < hobbies.length; i++) {
			System.out.print((i + 1) + "번째 입력 >> ");
			hobbies[i] = sc.next();
		}
		
		// 2. 출력 (for each)
		for (String hobby : hobbies) {
			System.out.print(hobby + " ");
		}
		System.out.println();
		
		sc.close();
		
	}

}
