package com.koreait.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionMain {

	public static void main(String[] args) {
		String resourceLocations ="classpath:appCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		ListHandler listHandler= ctx.getBean("handler1",ListHandler.class);
		listHandler.listInfo();
		
		SetHandler setHandler =ctx.getBean("handler2",SetHandler.class);
		setHandler.setInfo();
		
		MapHandler mapHandler = ctx.getBean("handler3",MapHandler.class);
		mapHandler.mapInfo();
		
		ctx.close();
	}

}
