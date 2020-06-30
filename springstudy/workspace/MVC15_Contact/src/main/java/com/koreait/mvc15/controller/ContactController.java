package com.koreait.mvc15.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvc15.command.ContactDeleteCommand;
import com.koreait.mvc15.command.ContactInsertCommand;
import com.koreait.mvc15.command.ContactListCommand;
import com.koreait.mvc15.command.ContactUpdateCommand;
import com.koreait.mvc15.command.ContactViewCommand;
import com.koreait.mvc15.common.Constant;
import com.koreait.mvc15.config.AnnoCTX;

@Controller
public class ContactController {
	
	// Field (@Autowired 로 자동 생성될 template, setTemplate 메소드의 매개변수가 자동생성되고, 매개변수가 Field 값으로 전달되는 방식)
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	// Field
	// AnnoCTX.java 에서 Bean 을 얻어오는 AnnotationConfigApplicationContext 클래스
	private AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoCTX.class);
	
	
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping("contactListPage")
	public String contactListPage(Model model) {
		ContactListCommand contactListCommand = ctx.getBean("contactListCommand", ContactListCommand.class);
		contactListCommand.execute(model);
		return "contact/contactListPage";
	}
	
	@RequestMapping("contactViewPage")
	public String contactViewPage(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ContactViewCommand contactViewCommand = ctx.getBean("contactViewCommand", ContactViewCommand.class);
		contactViewCommand.execute(model);
		return "contact/contactViewPage";
		
	}
	
	@RequestMapping("contactInsertPage")
	public String contactInsertPage() {
		return "contact/contactInsertPage";
	}
	
	@RequestMapping(value="contactInsert", method=RequestMethod.POST)
	public String contactInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ContactInsertCommand contactInsertCommand = ctx.getBean("contactInsertCommand", ContactInsertCommand.class);
		contactInsertCommand.execute(model);
		return "redirect:contactListPage";
	}
	
	
	@RequestMapping(value="contactUpdate", method=RequestMethod.POST)
	public String contactUpdate(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ContactUpdateCommand contactUpdateCommand = ctx.getBean("contactUpdateCommand", ContactUpdateCommand.class);
		contactUpdateCommand.execute(model);
		return "redirect:contactViewPage";
	}
	
	
	@RequestMapping(value="contactDelete", method=RequestMethod.POST)
	public String contactDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		ContactDeleteCommand contactDeleteCommand = ctx.getBean("contactDeleteCommand", ContactDeleteCommand.class);
		contactDeleteCommand.execute(model);
		return "redirect:contactListPage";
	}
	
}
