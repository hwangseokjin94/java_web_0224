package com.koreait.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoCTX {

	@Bean(name="gun")
	public Gun gun() {  // <bean id="gun" class="com.koreait.spring.Gun">
		Gun gun = new Gun();
		gun.setModel("베레타");
		gun.setBullet(6);
		return gun;
		// Gun gun = new Gun("베레타", 6);
		// return gun;
	}
	
}