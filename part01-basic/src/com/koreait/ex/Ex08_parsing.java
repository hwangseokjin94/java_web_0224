package com.koreait.ex;

public class Ex08_parsing {

	public static void main(String[] args) {
		
		/*
		 * 문자열 변환은 형 변환(casting)이 아니고, 구문 분석(parsing) 이다.
		 * 
		 * 1. 문자열 -> 정수 (String -> int)
		 *    String str1 = "100";
		 *    int a = Integer.parseInt(str1);
		 *    
		 * 2. 문자열 -> 실수 (String -> double)
		 *    String str2 = "1.5";
		 *    double b = Double.parseDouble(str2);   
		 * 
		 * 3. 문자열 -> 논리 (String -> boolean)
		 *    String str3 = "true";
		 *    boolean c = Boolean.parseBoolean(str3);
		 * 
		 * 4. 정수 -> 문자열 (int -> String)
		 *    int d = 100;
		 *    String str4 = String.valueOf(d);
		 *    String str4 = "" + d;
		 * 
		 * 5. 실수 -> 문자열 (double -> String)
		 *    double e = 1.5;
		 *    String str5 = String.valueOf(e);
		 *    String str5 = "" + e;
		 * 
		 */

		String strAge = "20";
		String strHeight = "180.5";
		
		int age = Integer.parseInt(strAge);
		double height = Double.parseDouble(strHeight);
		
		System.out.println("나이는 " + age + "살이고, 키는 " + height + "cm이다.");
		System.out.println("내년에는 " + (age + 1) + "살이다.");
		
	}

}
