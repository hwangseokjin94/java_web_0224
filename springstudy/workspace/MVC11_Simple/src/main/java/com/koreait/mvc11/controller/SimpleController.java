package com.koreait.mvc11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.mvc11.command.SimpleListCommand;

@Controller
public class SimpleController {

	//private SimpleConmmand command;
	@Autowired
	private SimpleListCommand simpleListCommand;
	//Field
	//@Autowired
	//1.root-context.xml ,servlet-context.xml에정의된 Bean을 자동으로 생성해 주세요
	
	
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	
	
	@RequestMapping("list")
	public String list(Model model) {
		//command = new SImpleListCommand(); 개발자가 생성하지 않고 DI를 적용한다.
		simpleListCommand.execute(model);//@Autowired에의해서 자동으로 생성되었다.
		return "simple/listPage";
	}
	
	
	
}













