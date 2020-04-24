package com.koreait.ex;

import java.util.Scanner;

public class Ex02_try_catch {

	public static void main(String[] args) {
	    try {
	    	//코드 작성
	    	Scanner sc = new Scanner(System.in);
			System.out.print("a 입력 >>");
			int a = sc.nextInt();
			
			System.out.print("b 입력 >>");
			int b = sc.nextInt();
			
			System.out.println(a+"+"+b+"="+(a+b));
			System.out.println(a+"-"+b+"="+(a-b));
			System.out.println(a+"*"+b+"="+(a*b));
			System.out.println(a+"/"+b+"="+(a/b));
			
			sc.close();
			
	    }catch(Exception e){
	    	System.out.println("문제가 발생하여 처리할수 없습니다.");
	    	
	    }
	    

	}

}
