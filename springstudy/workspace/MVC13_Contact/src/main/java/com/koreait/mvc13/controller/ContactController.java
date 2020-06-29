package com.koreait.mvc13.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvc13.command.ContactCommand;
import com.koreait.mvc13.command.ContactDeleteCommand;
import com.koreait.mvc13.command.ContactInsertCommand;
import com.koreait.mvc13.command.ContactListCommand;
import com.koreait.mvc13.command.ContactUpdateCommand;
import com.koreait.mvc13.command.ContactViewCommand;
import com.koreait.mvc13.common.Constant;

@Controller
public class ContactController {
	
	private ContactCommand command;
	
	//Constant.java 의 jdbcTemplate tmemplate생성
	private JdbcTemplate template; // 이건 Constant.java의 것이 아니고 ContactController것이다.
	
	@Autowired
	public void asdf(JdbcTemplate template) { //@Autowired에 자동으로 생성되는 bean은 매개변수 JdbcTemplate template 이다.
		this.template =template;
		Constant.template =  template;
	}
	@RequestMapping("/")
	public String goIndex() {
		return"index";
	}
	@RequestMapping("contactListPage")
	public String contactListPage(Model model) {
		//model 의 역활 :DB에서 가져온 contactList를 뷰(contactListPage.jsp)로전달
		command = new ContactListCommand();
		command.execute(model);
		
		return "contact/contactListPage";
	}
	
	//<a href="contactViewPage?cNo=${cDTO.cNo}">
	//파라미터 cNo 는 request에저장
	@RequestMapping("contactViewPage")
	public String contactViewPage(HttpServletRequest request,Model model) {
		//파라미터를 cNo를 ContactViewCommand 에전달하기위해서 request를 model에 전달
		model.addAttribute("request",request);
		command = new ContactViewCommand();
		command.execute(model);
		return"contact/contactViewPage";
	}
	
	@RequestMapping("contactInsertPage" )
	public String contactInsertPage() {		
		return"contact/contactInsertPage";
	}
	@RequestMapping(value="contactInsert" , method=RequestMethod.POST)
	public String  contactInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new ContactInsertCommand();
		command.execute(model);
		return"redirect:contactListPage";
	}
	
	@RequestMapping(value="contactDelete" , method=RequestMethod.POST)
	public String contactDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command= new ContactDeleteCommand();
		command.execute(model);
		return "redirect:contactListPage";
	}
	
	@RequestMapping(value="contactUpdate" , method=RequestMethod.POST)
	public String contactUpdate(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		command = new ContactUpdateCommand();
		command.execute(model);
		return "redirect:contactViewPage";
	}
}












