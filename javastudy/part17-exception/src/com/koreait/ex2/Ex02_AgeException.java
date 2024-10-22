package com.koreait.ex2;

import java.util.Scanner;

class Person {
	// field
	private int age;
	// method

	public void setAge(int age) throws AgeException {
		if (age < 0 || age > 120) {

			throw new AgeException("0~120사이의 나이만 입력가능하다.");
		}
		this.age = age;
	}
	public int getAge() {
		return age;
	}

}

class AgeException extends Exception {
	public AgeException(String message) {
		super(message);
	}
}

public class Ex02_AgeException {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("나이를 입력하세요");
			int age = sc.nextInt();
			Person p = new Person();
			p.setAge(age); //AgeException 발생
			System.out.println("나이 : "+p.getAge());

		} catch (AgeException e) {
			System.out.println("예외 메시지"+e.getMessage());
			
		}catch(Exception e) {
			System.out.println("예외 메시지"+e.getMessage());
		}finally {
			if(sc != null) {
				sc.close();
				}
		}

		
	}

}
