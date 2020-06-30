package com.koreait.mvc14.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvc14.command.ContactDeleteCommand;
import com.koreait.mvc14.command.ContactInsertCommand;
import com.koreait.mvc14.command.ContactListCommand;
import com.koreait.mvc14.command.ContactUpdateCommand;
import com.koreait.mvc14.command.ContactViewCommand;
import com.koreait.mvc14.common.Constant;

@Controller
public class ContactController {
	
	// Field (@Autowired 로 자동 생성될 command, setCommand 메소드의 매개변수가 자동생성되고, 매개변수가 Field 값으로 전달되는 방식)
	private ContactListCommand contactListCommand;
	private ContactViewCommand contactViewCommand;
	private ContactInsertCommand contactInsertCommand;
	private ContactUpdateCommand contactUpdateCommand;
	private ContactDeleteCommand contactDeleteCommand;
	
	@Autowired
	public void setCommand(ContactListCommand contactListCommand,
						   ContactViewCommand contactViewCommand,
						   ContactInsertCommand contactInsertCommand,
						   ContactUpdateCommand contactUpdateCommand,
						   ContactDeleteCommand contactDeleteCommand) { 
		this.contactListCommand = contactListCommand;
		this.contactViewCommand = contactViewCommand;
		this.contactInsertCommand = contactInsertCommand;
		this.contactUpdateCommand = contactUpdateCommand;
		this.contactDeleteCommand = contactDeleteCommand;
	}
	
	// Field (@Autowired 로 자동 생성될 template, setTemplate 메소드의 매개변수가 자동생성되고, 매개변수가 Field 값으로 전달되는 방식)
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping("contactListPage")
	public String contactListPage(Model model) {
		contactListCommand.execute(model);
		return "contact/contactListPage";
	}
	
	@RequestMapping("contactViewPage")
	public String contactViewPage(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
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
		contactInsertCommand.execute(model);
		return "redirect:contactListPage";
	}
	
	
	@RequestMapping(value="contactUpdate", method=RequestMethod.POST)
	public String contactUpdate(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		contactUpdateCommand.execute(model);
		return "redirect:contactViewPage";
	}
	
	
	@RequestMapping(value="contactDelete", method=RequestMethod.POST)
	public String contactDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		contactDeleteCommand.execute(model);
		return "redirect:contactListPage";
	}
	
}
