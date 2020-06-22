package com.koreait.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
 * @Configuration
 * 	: 이 클래스는 appCTX.xml과 같은 역할을 수행한다.
 * 
 * */



@Configuration
public class AnnoCTX {
	
	//Field 없음
	
	//Constructor 없음
	
	//method
	/*
	 * @Bean
	 * 	: 이 메소드는 Bean을 만드는 메소드이다.
	 * 	 
	 * */
	//<bean id="p1" class = "com.koreait.spring.Person">
	@Bean
	public Person p1() {		
		Person person = new Person();
		person.setName("에밀리"); // <property name = "name" value="에밀리"/>
		person.setAge(20);// <property name = "age" value="20"/>
		return person;
	}
	//<bean id ="p2" class = "com.koreait.spring.Person">
	//@Bean(name="bean의 id")
	
	@Bean(name="p2")
	public Person  ffsadfsadfewfwef() {
		Person person = new Person();
		person.setName("제임스"); // <property name = "name" value="제임스"/>
		person.setAge(25);// <property name = "age" value="25"/>
		return person;
	}
	//<bean id ="pInfo1" class = "com.koreait.spring.PersonHandler">
	@Bean
	public PersonHandler pInfo1() {
		PersonHandler handler = new PersonHandler();
		handler.setPerson(new Person("앨리스",30));
		return handler;		
	}
	//<bean id ="pInfo2" class = "com.koreait.spring.PersonHandler">
	@Bean
	public PersonHandler pInfo2() {
		PersonHandler handler = new PersonHandler();
		handler.setPerson(p1());
		return handler;		
	}
	//<bean id ="pInfo3" class = "com.koreait.spring.PersonHandler">
	@Bean
	public PersonHandler pInfo3() {
		PersonHandler handler = new PersonHandler();
		handler.setPerson( ffsadfsadfewfwef());
		return handler;		
	}
	
	
}
