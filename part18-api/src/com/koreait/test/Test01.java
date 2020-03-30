package com.koreait.test;

import java.util.Scanner;

public class Test01 {
	
	private static Scanner sc = new Scanner(System.in);
	
	
	
	// method inputFullName
	
	public static String inputFullName() {
		StringBuffer sb = new StringBuffer();
		System.out.println("성입력");
		String firstName = sc.next();
		System.out.println("이름 입력");
		String lastName = sc.next();
		// 성과 이름결합 체이닝 지원됨 어펜드 어펜드어펜드. .... ...
		sb.append(firstName).append(" ").append(lastName);

		return sb.toString(); //StringBuffer - > String 
	}

	public static void main(String[] args) {
		/*
		 * Test01.java 성(lastName), 이름(firstName)을 각각 입력 받아 하나의 이름(fullName)을 완성하시오.
		 * StringBuffer 클래스를 이용하시오. 위의 방식으로 두 이름을 입력 받아 두 이름(fullName)의 동등 비교를 진행하시오.
		 * 
		 * Scanner sc =new Scanner(System.in); String[] lastName = new String[2];
		 * String[] firstName = new String[2]; String [] fullName = new String[2];
		 * for(int i = 0; i<lastName.length ; i ++) {
		 * 
		 * System.out.println("성입력하세요");
		 * 
		 * lastName[i]= sc.next(); System.out.println("이름입력하세요"); firstName[i] =
		 * sc.next(); fullName[i]=lastName[i]+firstName[i];
		 * System.out.println(fullName[i]); } StringBuffer a = new
		 * StringBuffer(fullName[0]); StringBuffer b = new StringBuffer(fullName[1]);
		 * System.out.println(a.equals(b));
		 * 
		 */
		
		String fullName1 = inputFullName();
		String fullName2 = inputFullName();
		
		System.out.println("성명  1  "+ fullName1);
		System.out.println("성명  1  "+ fullName2);
		
		
		if(fullName1.equals(fullName2)) {
			System.out.println("같은이름");
		}else  {
			System.out.println("다른이름");
		}
		
		sc.close();
		
		
	}

}
