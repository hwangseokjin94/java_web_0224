package com.koreait.ex;

import java.util.ArrayList;
import java.util.List;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		// 1. List 의 VIEW 를 가진다. (ArrayList 만 가지고 있는 메소드는 사용할 수 없다.)
		// 2. 다형성을 가질 수 있다.

		// List<Integer> list = new ArrayList<Integer>();
		// List<Integer> list = new ArrayList<>(); 뒤에꺼는생략가능

		// 1.ArrayList 의 VIEW를 가진다. (List,ArrayList 의 모든 메소드를 사용가능하다.
		// 2.ArrayList 로 타입이 제한된다.
		// ArrayList<Integer> list = new ArrayList<Integer>();
		// ArrayList<Integer> list = new ArrayList<>(); 넷다가능함

//위에두개와 밑에두개의 차이점? >>>뷰가다르다  밑에거는 자식꺼이기떄문에 부모의것도사용가능하고 자기꺼도 사용가능하다.
//사용할수있는 메소드가 많은거는 밑에있는것이다.

		List<Integer> list = new ArrayList<Integer>();
		// 1. 저장 :add
		list.add(new Integer(10));
		list.add(new Integer(20));
		list.add(30); // int를 Integer로 자동으로 바뀌어주즌 Auto Boxing
		list.add(40);
		list.add(50);

		// 2.저장된요소 가져오기 : get(인덱스)
		list.get(0);
		list.get(4);

		System.out.println("첫번째요소" + list.get(0));
		System.out.println("마지막요소" + list.get(4));

		// 3.크기 : size()
		System.out.println("list의 크기 : " + list.size());
		// 1) 크기를 활용해 마지막요소 출력 :마지막 인덱스 = 크기 -1
		System.out.println("마지막요소" + list.get(list.size() - 1));

		// 2) 전체 요소 순회(for 문)
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + "번쨰요소 :" + list.get(i));
		}

		// 메소드를 호출하기떄문에 여러번 반복되기때문에 초기화를 변수에넣고 돌린다.

		// 3) 개선된 전체요소 순회 (일반 for문)
		// list.size()의 호출을 한번으로 줄인코드
		for (int i = 0, size = list.size(); i < size; i++) {
			System.out.println((i + 1) + "번쨰요소 :" + list.get(i));
		}

		// 4) 삭제 : remove(인덱스)
		// 첫 번쨰 데이터 삭제하기
		list.remove(0);
		System.out.println("삭제된 0번 인덱스 요소 : " + list.get(0));
		// 삭제 된 요소 를 비워두지않고 뒤에서 순차적으로 채운다.
		// 초~중반에 저장된 데이터가 자주 삭제되는 구조는 ArrayList가 부적절하다.

		// 5) 삭제 : remove(객체)
		// 50 을 찾아서 삭제하게
		list.remove(new Integer(50));

		// 6) 확인 : 저장 유무 확인 : contains(객체)
		// 저장된 50이 있는지 확인하는 코드
		for (int i = 0, size = list.size(); i < size; i++) {
			if (list.contains(new Integer(50))) {
				System.out.println("50이 있다.");
			}
		}

		// 저장된 50이 없는지 확인하는 코드
		for (int i = 0, size = list.size(); i < size; i++) {
			if (!list.contains(new Integer(50))) {
				System.out.println("50이 없다.");
				break;
			}
		}

		// 저장된 50이 없는지 확인하는 코드 플래그
		boolean isHere = false; // 여기없다

		if (list.contains(new Integer(50))) {
			isHere = true; // 여기 있다로 변경
		}

		System.out.println(isHere ? "50이 있다." : "50없다.");

		//7) 출력 (컬렉션은 그냥 출력해도된다.)
		System.out.println("list 전체 출력 = " +list);
		
		//8. 초기화
		list.clear();
		System.out.println("list 전체 출력 = " +list);
		
		
		
		
		
	}

}
