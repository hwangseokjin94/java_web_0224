package com.koreait.ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex04_Iterator {
	public static void main(String[] args) {
		// 반복자 Iterator
		// 1.컬렉션을 순회할 때 사용한다.
		// 2.기존 컬렉션 iterator()메소드를 부착해서 생성한다.
		// 3.인덱스 유무에 상관없이 사용할 수 있다.

		// 10,20,...100까지 데이터를 저장한 ArrayList
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add((i + 1) * 10);
		}

		// 1.반복자로 활용할 itr 객체 생성
		Iterator<Integer> itr = list.iterator();// 메소드를 부착하는 형태

		// 2.itr 객체를 이용한 순회
		// itr.hasNext(): 다음요소가 남아있느냐?
		// itr.next(): 다음요소를 꺼낸다.
		while (itr.hasNext()) {

			System.out.println(itr.next());
		}
		System.out.println("-------------------");
		// 3.itr은 재활용이(다시사용)안된다.
		while (itr.hasNext()) {

			System.out.println(itr.next());
		}
		// 4. itr 이 다시 필요하면? 다시만들면된다.
		itr = list.iterator();
		while (itr.hasNext()) {

			System.out.println("2 :"+itr.next());
		}

	}
}
