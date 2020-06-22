package com.koreait.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoCTX {
	
	//<bean id ="mySong" class="com.koreait.spring.Song"> 
	
	@Bean
	public Song mySong() {
		Song song = new Song();
		song.setTitle("Hello");
		song.setGenre("Balad");
		song.setPlayTime(4.5);
		return song;
	}
	//<bean id ="singer" class="com.koreait.spring.Singer">
	@Bean
	public Singer singer() {
		Singer s = new Singer();
		s.setName("adle"); // <property name="name" value="Adele"/> 
		s.setSong(mySong());// <property name="song" ref="mySong"/>
		return s;
	} 
	
}
