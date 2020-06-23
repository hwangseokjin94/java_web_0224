package com.koreait.spring;

import org.springframework.beans.factory.annotation.Autowired;


public class Computer {
	@Autowired //speaker타입의bean을 찾아서 자동으로 주입해준다.
	private Speaker speaker;
	public void playGame() {
	System.out.println("게임을한다.");	
	}
	public void devApp() {
		System.out.println("개발을한다.");	
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
