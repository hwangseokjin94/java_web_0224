package com.koreait.ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ex08_HashMap2 {
	public static void main(String[] args) {
		//name, age,height정보를 입력받아 (Scanner)
		//HashMap에 저장하고 저장된 entry 들을 확인하는 코드
		//Key value
		//name "홍길동"
		//age  20
		//height 180.5
		
		
		
		
		
		Scanner sc = new Scanner(System.in);
		
		Map<String,String> person= new HashMap<>();
		
		System.out.print("이름 입력>>>");
		person.put("name", sc.next());
		
		System.out.print("나이 입력>>>>");
		person.put("age", sc.nextInt()+"");
		System.out.print("키 입력>>>>>>");
		person.put("height", sc.nextDouble()+"");
			 
		Set<String> set = person.keySet();
		Iterator<String> itr =set.iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			String value = person.get(key);
			System.out.println(key + ":"+ value);
		}
		sc.close();
		
		
		
		
		
		
		
		
		
	}
}
