package com.koreait.mvc15.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.mvc15.command.ContactDeleteCommand;
import com.koreait.mvc15.command.ContactInsertCommand;
import com.koreait.mvc15.command.ContactListCommand;
import com.koreait.mvc15.command.ContactUpdateCommand;
import com.koreait.mvc15.command.ContactViewCommand;

@Configuration  // 나는 Bean을 만드는 클래스이다.
public class AnnoCTX {

	@Bean  // 나는 Bean이다.
	// 리턴타입 : Bean 타입 (bean class)
	// 메소드명 : Bean 이름 (bean id)
	public ContactListCommand contactListCommand() {
		return new ContactListCommand();
	}
	
	@Bean
	public ContactViewCommand contactViewCommand() {
		return new ContactViewCommand();
	}
	
	@Bean
	public ContactInsertCommand contactInsertCommand() {
		return new ContactInsertCommand();
	}
	
	@Bean
	public ContactUpdateCommand contactUpdateCommand() {
		return new ContactUpdateCommand();
	}
	
	@Bean
	public ContactDeleteCommand contactDeleteCommand() {
		return new ContactDeleteCommand();
	}
	
}