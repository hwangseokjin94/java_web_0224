package com.koreait.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoCTX {


	@Bean
	public Student s1() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(40);
		
		HashSet<String> set = new HashSet<String>();
		set.add("수집하기");
		set.add("욕조청소");
		set.add("보육원지원");
		
		HashMap<String, String> homeInfo =  new HashMap<String, String>();
		homeInfo.put("address", "부천");
		homeInfo.put("phone", "010-111-1111");
		
		Student student = new Student();
		student.setName("애밀리");
		student.setScores(list);
		student.setVolunteers(set);
		student.setHomeInfo(homeInfo);
		return student;
	}
	
	
}
