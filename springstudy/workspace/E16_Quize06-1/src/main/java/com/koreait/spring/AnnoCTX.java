package com.koreait.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:appCTX.xml")
@Configuration
public class AnnoCTX {

	@Bean
	public Engine myEngine() {
		return new Engine();
	}
	@Bean
	public Car myCar() {
		Car car = new Car();
		car.setModel("520d");
		car.setEngine( myEngine() );
		return car;
	}
	
	
	
	
	
	
}
