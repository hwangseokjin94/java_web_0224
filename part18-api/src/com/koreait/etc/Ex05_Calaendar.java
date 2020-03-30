package com.koreait.etc;

import java.util.Calendar;

public class Ex05_Calaendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Calendar 날짜와 시간을 다루는 클ㄹ래스
		//Calendar 생성은 getInstance()메소드를 이용한다
		Calendar cal = Calendar.getInstance();
		//1.확인은 필드를 이용한다.
		//년 월 일
		
		System.out.println("년 :"+cal.get(Calendar.YEAR));
		System.out.println("월 :"+(cal.get(Calendar.MONTH)+1)); //0~11
		System.out.println("일 :"+cal.get(Calendar.DAY_OF_MONTH)); //ㅊ

		//일  1월2화3수4목
		System.out.println("요일번호"+cal.get(Calendar.DAY_OF_WEEK));
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:System.out.println("일요일");break;
		case 2:System.out.println("웧요일");break;
		case 3:System.out.println("화요일");break;
		case 4:System.out.println("수요일");break;
		case 5:System.out.println("목요일");break;
		case 6:System.out.println("금요일");break;
		case 7:System.out.println("토요일");break;
		}
		
		//오전오후
		System.out.println("오전오후"+cal.get(Calendar.AM_PM));
		System.out.println("12시 : "+cal.get(Calendar.HOUR));
		System.out.println("24시 : "+cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 : "+cal.get(Calendar.MINUTE));
		System.out.println("초 : "+cal.get(Calendar.SECOND));
		System.out.println("밀리초 : "+cal.get(Calendar.MILLISECOND));
		System.out.println("밀리초 ->초 : "+cal.get(Calendar.MILLISECOND)/1000.0+"초");
		
		//2변경
		cal.set(2020, 1, 28, 10, 20, 30); //2020 년 2월 28일 10시 20분 30초
		
		//3.날짜를 밀리초로 변환
		long millisecond =cal.getTimeInMillis();
		System.out.println("밀리초 : " + millisecond);
		
		
		
		//번외
		//현재시간을 밀리초 단위의 long타입으로 반환하는 메소드
		System.out.println(System.currentTimeMillis());
		
		long start = System.currentTimeMillis();
		for(int i =0 ; i<2_000_000_000;i++);
		long end = System.currentTimeMillis();
		System.out.println("경과시간 = "+(end - start));
		
		
		
		}
			
	
	
}
