package com.koreait.ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex06_HashMap {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		// 1. 추가 : put(key, value)
		// 1) key :중복이 불가능하다.
		// 2)value :중복이 가능하다.
		map.put("앨리스", 20);
		map.put("제임스", 30);
		map.put("데이빗", 25);
		map.put("사만다", 35);
		map.put("앨리스", 40);// 어떤 동작을 할것인가??? >작동하고 덮어쓰기
							// 기존 Key값을 찾아서 수정한다.

		// 2. 저장된요소 가져오기 : get(key)
		System.out.println("앨리스(key)의 나이(value) : " + map.get("앨리스"));
		System.out.println(map); // key값으로 많이사용하는 타입? >>String

		// 3.삭제: remove(key)
		map.remove("제임스");
		System.out.println(map);

		// 4.확인 : containsKey(key)
		if (map.containsKey("앨리스")) {
			System.out.println("앨리스가 있다.");
		}

		// 5.크기:size()
		System.out.println("map크기:" + map.size());

		// 6.순회
		// 1) key 만 Set로뺀다. (keySet()메소드)
		// 2) Set 에 Iterator를 붙인다.(iterator()메소드)
		// 3) Set 요소를 뺴서 map 의 key로 사용한다.(hasNext(),next(),get()메소드)
		Set<String> set = map.keySet();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
//			itr.next() ==key
			String key = itr.next();
			Integer value = map.get(key);
			System.out.println("키 : "+key +" , 값 : "+value);
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
