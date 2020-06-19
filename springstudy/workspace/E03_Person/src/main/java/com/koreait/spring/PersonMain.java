package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
/*	    이주석부분은 appCTX.xml로 처리한다.
 * 	// 디폴트 생성
		Person person1 = new Person();
		//2 Setter를 통한주입
		person1.setName("제임스");
		person1.setAge(20);
		person1.setGender('남');
		person1.setPhone("010-1111-1111");
		
		//2. 1필드를이용한 생성자로 주입
		Person person2 = new Person("앨리스",30,'여',"010-2222-2222");
		
		//3.1 디폴트 생성
		PersonHandler handler1 = new PersonHandler();
		
		//3.2 Setter를 통한주입
		handler1.setPerson(person1);
		
		//4. 필드를 이용한 생성자로 주입
		PersonHandler handler2 = new PersonHandler(person2);
		*/
		
		String resourceLocations = "classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		//getBean("bean태그의 id",bean 태그의 클래스)
		PersonHandler handler1 =ctx.getBean("handler1",PersonHandler.class);
		PersonHandler handler2 = ctx.getBean("handler2",PersonHandler.class);
		
		handler1.personInfo();
		handler2.personInfo();
		
		
		
		
	}

}
