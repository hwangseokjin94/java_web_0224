package com.koreait.test;

import java.math.BigInteger;

public class Test02 {
/*
 * Test02.java
1! ~ 99! 까지 전체 결과를 출력하시오.
1! (1 팩토리얼) = 1
2! (2 팩토리얼) = 1 * 2 = 2
3! (3 팩토리얼) = 1 * 2 * 3 = 6
...
99!
				N! = (N-1)!*N
 * 
 * */
	/*
	public static int factorial(int n ) {
		if(n == 1) {
			return 1;
		}else {
			return factorial(n-1)*n;
		}
	}
	*/
	public static BigInteger factorial(BigInteger n ) {
		if(n.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}else {
			return factorial (n.subtract(BigInteger.ONE)).multiply(n);
		}
	}
	
	//valueOf
	
	public static void main(String[] args) {
		for(int n = 1 ; n < 100 ; n ++) {
			System.out.println(n+"!="+" 팩토리얼 ="+factorial(BigInteger.valueOf(n)));
			
		}
		
	}
}
//
//Integer.valueOf("10")  ==  Integer.parseInt("10")
//Double.valueOf("1.5") == Double.parseDouble("1.5")
//String.valueOf  == ""+10 == "10"


