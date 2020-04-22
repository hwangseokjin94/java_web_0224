package com.koreait.ex2;

import java.util.Scanner;

//같은패키지에 같은 클래스 들어갈수없다.
class Human {
	//14자리하이픈 포함
	private String perID;


	public String getPerID() {
		return perID;
	}
	public void setPerID(String perID) throws PerIDException{
		if(perID.length()!=14 || perID.charAt(6)!='-') {
			throw new PerIDException("올바른 주민등록번호가 아니다.");
		}
		this.perID = perID;
	}
	
	
}
@SuppressWarnings("serial")//직렬화 처리를 안했다고 경고 메시지 띄우지마라
class PerIDException extends Exception{
	public PerIDException(String message) {
		super(message);
	}
}
public class Ex03_PerIDException {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("주민등록번호를입력해주세요(하이픈포함)");
			String perID = sc.next();
			Human h = new Human();
			h.setPerID(perID);
			System.out.println("당신의주민은"+h.getPerID());
		}catch(PerIDException e) {
			System.out.println("예외메시지"+e.getMessage());
			
		}catch (Exception e) {
			System.out.println("예외메시지"+e.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
