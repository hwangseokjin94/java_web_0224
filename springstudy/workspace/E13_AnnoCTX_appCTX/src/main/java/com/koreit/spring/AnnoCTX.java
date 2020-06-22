package com.koreit.spring;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoCTX {

	@Bean
	public Person person2() {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("축구");
		list.add("야구");
		list.add("농구");
		
		Person person = new Person();
		person.setName("유재석");
		person.setHobbies(list);
		return person;
	}
}
