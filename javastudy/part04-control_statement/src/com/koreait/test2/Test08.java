package com.koreait.test2;

public class Test08 {

	public static void main(String[] args) {
		/*Test08.java
369 게임
1 ~ 99 사이 369 게임 결과를 아래와 같이 출력하기
한 줄에 10개씩만 출력하기
출력 예)
1	2	짝	 4	5	짝	 7	8	짝	 10
11	12	짝	 14	15	짝	 17	18	짝	 20
21	22	짝	 24	25	짝	 27	28	짝	 짝
짝	짝	짝짝 짝	짝	짝짝 짝	짝	짝짝 40	
...*/
    /*
     String c= "짝";
     String d= "짝짝";
     for(int i=1;i<100;i++) {
    	 if(i%10==0) {
    		 System.out.println(i+"  ");
    	 }
    	 if(i%3==0) {
        	 System.out.print(c+"  ");
        	 }
    	 else {
    	 System.out.print(i+"  ");
    	 }
     }
    */
		
		boolean condition1=false;//일의 자리가 3의 배수인가?
		boolean condition2=false;//십의 자리가 3의 배수인가?
		
		for(int n=1;n<100;n++) {
			condition1=(n%10)%3==0 && (n%10) != 0;
			condition2 = (n/10)%3 == 0 &&(n/10) !=0;
			
			if( condition1 && condition2 ) {
				System.out.print("짝짝\t");
				
			}else if(condition1||condition2) {
				System.out.print("짝\t");
			}else {
				System.out.print(n+"\t");
			}
			if(n%10==0) {
				System.out.println();
			}
		}
		
		
		
		
	}

}
