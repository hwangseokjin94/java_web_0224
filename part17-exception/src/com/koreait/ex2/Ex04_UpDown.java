package com.koreait.ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

class UpDown {
	
	// Field
	private int answer;  // 정답
	private int count;  // 시도 횟수
	private Scanner sc = new Scanner(System.in);  // 모든 메소드에서 sc 사용 가능
	
	// Constructor
	public UpDown() {
		// 1 ~ 100 사이의 난수 발생
		answer = (int)(Math.random() * 100) + 1;
	}
	
	// Method
	public int challenge() throws NumberOutOfBoundsException, InputMismatchException {
		// 사용자가 입력한 값이 리턴
		count++;
		System.out.print("1 ~ 100 사이 정수 입력 >> ");
		int n = sc.nextInt();
		if ( n < 1 || n > 100 ) {
			throw new NumberOutOfBoundsException("1 ~ 100 사이만 입력 가능합니다.");
		}
		return n;
	}
	public void play() {
		// 모든 로직 처리
		while (true) {
			try {
				int n = challenge();
				if (answer < n) {
					System.out.println("Down!");
				} else if (answer > n) {
					System.out.println("Up!");
				} else {
					System.out.println("정답 : " + answer + "(" + count + "번 만에 성공했다.)");
					// break;  // 무한루프의 종료
					return;  // play() 메소드의 종료
				}
			} catch (NumberOutOfBoundsException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("정수만 입력 가능합니다.");
				clearInputBuffer();
			}  
		}  // while
	}  // play()
	
	public void clearInputBuffer() {
		sc.next();
	}
	
}


// 사용자가 1 ~ 100 이외의 범위 값을 입력하면 
// NumberOutOfBoundsException 예외 발생


@SuppressWarnings("serial")
class NumberOutOfBoundsException extends Exception {
	public NumberOutOfBoundsException(String message) {
		super(message);
	}
}


public class Ex04_UpDown {
	public static void main(String[] args) {
		UpDown game = new UpDown();
		game.play();
	}
}
