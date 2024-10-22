package com.koreait.etc;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Ex04_big_number {
	public static void main(String[] args) {
		//primitive type의 최대값
		//int 형 최대값.
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);

		//BigInteger 클래스를 활용해서 long 타입 이상 이하 값을 저장한다.
		BigInteger a= new BigInteger("12345678901234567890");
		BigInteger b= new BigInteger("123456789012345678901234567890");
		
		System.out.println(a);
		//BigInteger 클래스의 필드값.
		System.out.println(BigInteger.ZERO);
		System.out.println(BigInteger.ONE);
		System.out.println(BigInteger.TEN);
		//System.out.println(	a.ZERO);
		
		//BigInteger 클래스으 사칙연산
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
		System.out.println(a.divide(b));
		System.out.println(a.remainder(b));
		
		//BigDecimal 클래스  이용해 실수의  소수자리수를  손실없이 사용할수있다.
		double c = 1.1234567890123456789;
		BigDecimal d = new BigDecimal("1.123456789012345678901234567890");
		
		System.out.println(c);
		System.out.println(d);
		
	}
}
