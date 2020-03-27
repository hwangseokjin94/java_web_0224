package com.koreait.ex;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex06_break {

	public static void main(String[] args) {
		
		// 1. 1 ~ 100 모든 정수의 합을 구하기
		// 단, 합이 2000 이상이면 멈추고 어디까지 더한 결과가 최초 2000 이상인지 출력하기
		int total = 0;  // 합계 변수 초기화 0
		int n;
		for (n = 1; n < 101; n++) {
			total += n;
			if (total >= 2000) {
				break;
			}
		}
		System.out.println(n);
		
		
		// 2. "admin" 아이디가 입력될때까지 계속 입력받기
		// 몇 번만에 입력되었는지 출력
		Scanner sc = new Scanner(System.in);
		String userId = "";
		int count1 = 0;
		
		while (true) {  // 무한루프
			System.out.print("아이디 입력 >> ");
			userId = sc.next();
			count1++;
			if ( userId.equals("admin") ) {
				break;
			}
		}
		
		System.out.println("admin은 " + count1 + "번만에 입력됨.");
		
		// 3. 수도 맞추기
		// 대한민국의 수도를 맞출때까지 묻기
		// 몇 번만에 맞췄는지 함께 출력
		String city = "";
		int count2 = 0;
		
		while (true) {
			System.out.print("대한민국의 수도는? >> ");
			city = sc.next();
			count2++;
			if ( city.equals("서울") || city.equalsIgnoreCase("seoul") ) {
				break;
			}
		}
		
		System.out.println(count2 + "번만에 정답.");
		
		sc.close();
		
		
		// 4. 비밀번호가 "1234"이면 종료 아니면 계속 입력받기
		// 최대 5번까지 시도 가능
		// "성공", "실패" 출력하기
		String pw = "";
		boolean isSuccess = false;
		
		for (int a = 0; a < 5; a++) {  // 5번의 반복 진행
			pw = JOptionPane.showInputDialog("비밀번호를 입력하세요.");
			if (pw.equals("1234")) {
				isSuccess = true;
				break;
			}
		}
		
		if (isSuccess) {
			JOptionPane.showMessageDialog(null, "성공");
		} else {
			JOptionPane.showMessageDialog(null, "실패");
		}
		
		
	}

}






