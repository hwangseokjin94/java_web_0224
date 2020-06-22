package com.koreait.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoCTX {

	
	@Bean(name="engine")
	public Engine engine() {
		Engine engine =  new Engine() ;
		engine.setFuelType("디젤");
		engine.setCc(1991);
		engine.setHp(245);
		engine.setFuelEfficiency(12.5);
		return engine;
	}
	
	
}
