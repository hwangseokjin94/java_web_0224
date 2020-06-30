package com.koreait.mybatis3.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.mybatis3.command.ContacCommand;
import com.koreait.mybatis3.command.ContactDeleteCommand;
import com.koreait.mybatis3.command.ContactInsertCommand;
import com.koreait.mybatis3.command.ContactListPageCommand;
import com.koreait.mybatis3.command.ContactViewPageCommand;

@Controller
public class ContactController {

	
	//field
		@Autowired
		private SqlSession sqlSession;//@Autowired는 여기까지 만 적용된다.
		private ContacCommand contacCommand;
		
		
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	@RequestMapping("contactListPage")
	public String contactListPage(Model model) {
		contacCommand = new ContactListPageCommand();
		contacCommand.execute(sqlSession, model);
		return "contact/contactListPage";
	}
	
	@RequestMapping("contactInsertPage")
	public String contactInsertPage() {
		return "contact/contactInsertPage";
	}
	@RequestMapping("contactInsert")
	public String contactInsert(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		contacCommand = new ContactInsertCommand();
		contacCommand.execute(sqlSession, model);
		return "redirect:contactListPage";
	}
	
	@RequestMapping("contactViewPage")
	public String contactViewPage(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		contacCommand = new ContactViewPageCommand();
		contacCommand.execute(sqlSession, model);
		return "contact/contactViewPage";
	}
	@RequestMapping("contactDelete")
	public String contactDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);
		contacCommand = new  ContactDeleteCommand();
		contacCommand.execute(sqlSession, model);
		return "redirect:contactListPage";
	}
	
		
}
