package com.koreait.test2;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Test09 {

	public static void main(String[] args) {
		/*Test09.java
전체 구구단을 아래 화면처럼 출력하기
2x1=1	3x1=3	...		9x1=9
2x2=4	3x2=6	...		9x2=18
...
2x9=18	3x9=27	...		9x9=81
JOptionPane.showMessageDialog() 메소드를 이용해 구현하기
* */
		int dan , n ;
		String message = "";
       for(n=1;n<10;n++ ) {
    	   for(dan=2;dan<10;dan++) {
    		   message +=(dan+"X"+n+"="+(dan*n)+"\t"); 
    	   }
    	   message +="\n";
       }
		
		
		//텍스트에이리어를 사용해 \t 를 못쓰는 것을 수정가능함
		JOptionPane.showMessageDialog(null, new JTextArea(message));
		
		
		
		
		
	}

}
