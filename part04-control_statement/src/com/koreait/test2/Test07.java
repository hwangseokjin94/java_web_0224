package com.koreait.test2;

import javax.swing.JOptionPane;

public class Test07 {

	public static void main(String[] args) {
		/*Test07.java
로그인 시뮬레이션 (JOptionPane)
문제) 아이디 : admin, 비밀번호 : 1234 인 회원의 로그인 상황
1) 아이디 입력 성공 -> 비밀번호 입력으로 이동
2) 아이디 입력 실패 -> 다시 아이디 입력 (횟수 제한 없음)
3) 비밀번호 입력 성공 -> "로그인 성공" 메시지 출력
4) 비밀번호 입력 실패 -> 다시 비밀번호 입력 (횟수 제한 5회까지만 가능)
   5회 초과 시 -> "비밀번호 입력 횟수 초과" 메시지 출력
*/
	/*	
		Scanner sc = new Scanner(System.in);

	
		int count=0;
		System.out.println("아이디를 입력하세요");
		String userId =sc.next();
		if(userId.equals("admin")) {
			System.out.println("비밀번호를 입력하세요입력하세요");
			String userPw =sc.next();
			if(userPw.equals("1234")) {
				System.out.println("로그인성공");
			}else if(count==5) {
				System.out.println("비밀번호다시입력해");
				count++;
			}else {
				System.out.println("비밀번호 입력초과");
			}
			
		}else {
			System.out.println("아이디를 다시입력하세요");
		}	
       sc.close();
       */
		
		String Id ="";
		String Pw ="";
		final int MAX_COUNT =5;// 최대횟수 상수(상수는 대문자로)
		int count = 0 ;//카운팅
		//1.
		do {
			Id=JOptionPane.showInputDialog("아이디를 입력하세요");
		}while(!Id.equals("admin"));
		
		//2.pw
		do {
			count++;
			if(count>MAX_COUNT) {
				JOptionPane.showMessageDialog(null, "비밀번호입력횟수 초과");
				return;//리턴타입이 없는 메소드의 종료(main메소드)
//				System.exit(0);;
			}
			Pw = JOptionPane.showInputDialog("pw를 입력하세요 최대 5회");
		}while(!Pw.equals("1234"));
		
		//3.출력
		JOptionPane.showMessageDialog(null, "로그인 성공");
		
		
		
		
		
		
	}

}
