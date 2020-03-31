package com.koreait.ex;

import java.util.ArrayList;
import java.util.List;

public class Ex02_ArrayList {
	public static void main(String[] args) {
		// 1~1000 사이의 정수를 저장한 ArrayList 생성
		Integer[] intArray = new Integer[1000];
		List<Integer> list = new ArrayList<Integer>(1000);// 초기크기 1000

		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (i + 1);
			list.add(intArray[i]);
		}
		System.out.println(list);

		// 맨뒤의 데이터부터 순차적으로 삭제
		long start = System.nanoTime();
		for (int i = list.size() - 1; i > -1; i--) {
			list.remove(i);
		}

		// 맨처음의 데이터부터 순차적으로 삭제

		for (int i = 0; i < list.size(); i++) {
			list.remove(0);
		}

		long end = System.nanoTime();// 나노 10억분의 1
		System.out.println("총 경과시간 :" + (end - start) + "ns");
		// 동일한코드로짜도 성능이다르다 자료구조 를통해 학습하도록
		

	}
}
