package com.koreait.spring;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoCTX {


	@Bean
	public Police policeInfo() {
		Gun g = new Gun();
		g.setModel("베레타");
		g.setBullet(6);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("부서명", "강력반");
		map.put("부서위치", "102호");
		Police police = new Police();
		police.setName("제임스");
		police.setDeptInfo(map);
		police.setPistol(g);
		return police;
	}
	
}
