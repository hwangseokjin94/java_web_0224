package com.koreait.spring;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/*
 * appCTX.xml 로 생성하는 Bean을
 * AnnoCTX.java 에서 생성할 수 있도록 처리하는 방법
 *   : 앞으로 AnnoCTX.java 을 사용하겠다.
 * 
 * 클래스에 @ImportResource 를 추가한다.
 * @ImportResource("classpath:appCTX.xml")
 */

@ImportResource("classpath:appCTX.xml")
@Configuration
public class AnnoCTX {

	@Bean
	public Person person2() {
	
		ArrayList<String> list = new ArrayList<String>();
		list.add("피파");
		list.add("스타");
		list.add("롤");
	
		Person person = new Person();
		person.setName("제임스");
		person.setHobbies(list);
	
		return person;
		
	}
	
}
