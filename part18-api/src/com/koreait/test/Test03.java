package com.koreait.test;

import java.util.Calendar;

public class Test03 {

	public static void main(String[] args) {
		/*Test03.java
현재 날짜를 StringBuffer, Calendar 클래스를 이용하여
"2019년 10월 21일 월요일 오후 1시 10분" 과 같은 형식으로 완성하고 출력하시오.*/
		
		
			
			// "2019년 10월 21일 월요일 오후 1시 10분"
			
			StringBuffer sb = new StringBuffer();
			
			Calendar cal = Calendar.getInstance();

			sb.append(cal.get(Calendar.YEAR) + "년 ");
			sb.append((cal.get(Calendar.MONTH) + 1) + "월 ");
			sb.append(cal.get(Calendar.DAY_OF_MONTH) + "일 ");
			
			String[] weekName = {"", "일", "월", "화", "수", "목", "금", "토"};
			int i = cal.get(Calendar.DAY_OF_WEEK);
			sb.append(weekName[i] + "요일 ");
			
			sb.append(cal.get(Calendar.AM_PM) == 0 ? "오전 " : "오후 ");
			sb.append(cal.get(Calendar.HOUR) + "시 ");
			sb.append(cal.get(Calendar.MINUTE) + "분");
			
			System.out.println(sb);
			
	}

}
