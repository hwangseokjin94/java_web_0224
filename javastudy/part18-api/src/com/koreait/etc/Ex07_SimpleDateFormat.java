package com.koreait.etc;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *SimpleDateFormat의 형식
 * 1. 년 : yy,yyyy
 * 2. 월 : M,MM
 * 3. 일 : d,dd
 * 4. 요일 :E
 * 5.오전/오후  a
 * 6.시 : hh(12시각제), HH(24시각제)
 * 7.분 : mm
 * 8.초 : ss
 * 
 * 
 * */ 
public class Ex07_SimpleDateFormat {

	public static void main(String[] args) {
		//2020 년 3월 27일 금요일 오후 2:21
		Date today = new Date();
		String pattern = "yyyy년 M월 d일 E요일 a hh:mm ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String now = sdf.format(today);
		System.out.println("현재 날짜와 시간 : "+now);
	}

}
