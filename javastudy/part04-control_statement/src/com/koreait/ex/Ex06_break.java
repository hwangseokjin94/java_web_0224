package com.koreait.ex;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex06_break {

	public static void main(String[] args) {
	/*  //1. 1~100모든 정수의 합을 구하기
	 // 단, 합이 2000이상이면 멈추고 합과 어디까지 더한결과가 최초 2000이상인지 출력하기
	int total = 0;
	int n;
	for( n =1 ;n <101; n++) {
		
		total += n;
		if(total >=2000) {
			break;
		}
	
 	 }
	System.out.println(n);
	
	//2.admin아이디가 입력될ㄸ까지 입력ㄱ받기
	Scanner sc = new Scanner(System.in);
	String userId = "";
	int count1 = 0;
	while(true){
		System.out.print("아이디를 입력해주세요");
		userId =sc.next();
		System.out.println("다시입력해주세요");
		count1 ++;
		if(userId.equals("admin")) {
			
			break;
		}
	}
	System.out.println(count1+"번만에 맞았습니다.습니다");
	
	
	
	
	
	//3.대한민국 수도맞추기 몇번 뭦췄는지
	String city = "";
	int count2 =0 ;
	System.out.println("수도를 입력해주세요");
	while(true) {
		
		System.out.println("대한민국의 수도는?");
		city =sc.next();
				count2++;
		if(city.equals("서울")|| city.equalsIgnoreCase("seoul")) {
			break;
		                            }
	             }
	System.out.println( count2+"번만에정답입니다");
	sc.close();
	*/
	//4. 비밀번호가 1234로 이면 종료하고 아니면 계ㅖ속 입력받기
	// 최대 5번까지 시도가능
	// "성공 실패여부"
	String pw = "";
	boolean  isSuccess = false ;
	
	
	
	for(int i = 0 ; i <5; i++) {//5번의 반복진행
		 pw = JOptionPane.showInputDialog("비밀번호는?");
		
		if(pw.equals("1234")) {
			isSuccess =true;
			break;
			
			}
	}
	if(isSuccess) {
		JOptionPane.showMessageDialog(null, "성공");
	}else {
	JOptionPane.showMessageDialog(null, "실패");
	}
	
		
}//main

}
