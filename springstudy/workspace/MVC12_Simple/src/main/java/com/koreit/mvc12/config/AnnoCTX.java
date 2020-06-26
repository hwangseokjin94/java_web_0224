package com.koreit.mvc12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreit.mvc12.command.SimpleDeleteConmmand;
import com.koreit.mvc12.command.SimpleInsertConmmand;
import com.koreit.mvc12.command.SimpleListCommand;
import com.koreit.mvc12.command.SimpleUpdateConmmand;
import com.koreit.mvc12.command.SimpleViewCommand;

//난  root-context.xml과같은 역활이야


@Configuration
public class AnnoCTX {

	
	//1.Bean 이름 = 메소드이름
	//2.Bean클래스타입 = 리턴타입
	
	//난 Bean이야
	@Bean
	public SimpleListCommand simpleListCommand() { //ctx.getBean("simpleListCommand",SimpleListCommand.class)
		return new SimpleListCommand();
	}
	
	@Bean
	public SimpleViewCommand simpleViewCommand() {
		return new SimpleViewCommand();
	
	}
	@Bean
	public SimpleDeleteConmmand simpleDeleteConmmand() {
		return new SimpleDeleteConmmand();
		
	}
	@Bean
	public SimpleInsertConmmand simpleInsertConmmand() {
		return new SimpleInsertConmmand();
		
	}
	@Bean
	public SimpleUpdateConmmand simpleUpdateConmmand() {
		return new SimpleUpdateConmmand();
		
	}
	
}
