package com.koreait.ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex05_HashSet {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet<String>();
		
		//추가 : add
		set.add("C");
		set.add("JAVA");
		set.add("DB");
		set.add("HTML");
		set.add("CSS");
		set.add("JAVASCRPIT");
		set.add("JQUERY");
		set.add("JSP");
		set.add("SPRING");
		
		set.add("JAVA");//중복
		set.add("JSP");//중복
		
		//인덱스가 없기떄문에,
		//반복자 Iterator를 통해서 순회한다.
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
