package com.koreait.mvc14.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvc14.command.ContactCommand;
import com.koreait.mvc14.command.ContactInsertCommand;
import com.koreait.mvc14.command.ContactListViewCommand;
import com.koreait.mvc14.command.ViewPageCommand;
import com.koreait.mvc14.common.Constant;

@Controller
public class ContactController {
	
	private  ContactCommand command;
	
	private JdbcTemplate template;
	
	@Autowired
	private void lkasnf(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
		
	}
	
	@RequestMapping("/")
	public String goIndex() {
		return "Index";
	}
	@RequestMapping("map")
	public String map() {
		return "map";
	}
	
	@RequestMapping("ContactViewPage")
	public String ContactViewPage(Model model) {
		command = new ContactListViewCommand();
		command.execute(model);
		return"contact/ContactViewPage";
	}
	@RequestMapping("ViewPage")
	public String ViewPage(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new ViewPageCommand();
		command.execute(model);
		return"contact/ViewPage";
	}
	
	
	@RequestMapping("contactInsertPage")
	public String contactInsertPage() {
		return"contact/contactInsertPage";
	}
	
	@RequestMapping(value="contactInsert" , method=RequestMethod.POST)
	public String contactInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new ContactInsertCommand();
		command.execute(model);
		return"redirect:ContactViewPage";
	}
	
	
	
	@RequestMapping("update")
	public String update(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new ViewPageCommand();
		command.execute(model);
		return"";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new ViewPageCommand();
		command.execute(model);
		return"";
	}
	
}
