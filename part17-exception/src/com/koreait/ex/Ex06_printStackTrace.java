package com.koreait.ex;
public class Ex06_printStackTrace {
	public static void main(String[] args) {
		try {
			System.out.println(args[1]); //ArrayIndexOutOfBoundException 예외 발생 //
			
	
		}catch(Exception e){
			//System.out.println(e.getMessage());
			e.printStackTrace(); //예외가 발생한 구역을 순차적으로 추적해주는 메소드...
		}
		
		//개발자
		//1.개발당시 예외처리 : e.printStackTrace()
		//2.개발완료후 : 적절한예외메시지등 처리                                                                                                                                                                                                                                 
		
		
	}//main
}
