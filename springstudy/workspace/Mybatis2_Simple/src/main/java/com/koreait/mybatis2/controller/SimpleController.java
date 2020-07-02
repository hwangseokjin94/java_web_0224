package com.koreait.mybatis2.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mybatis2.command.SImpleViewCommand;
import com.koreait.mybatis2.command.SimpleCommand;
import com.koreait.mybatis2.command.SimpleDeleteCommand;
import com.koreait.mybatis2.command.SimpleInsertCommand;
import com.koreait.mybatis2.command.SimpleListCommand;
import com.koreait.mybatis2.command.SimpleUpdateCommand;

@Controller
public class SimpleController {
	//field
	@Autowired
	private SqlSession sqlSession;//@Autowired는 여기까지 만 적용된다.
	private SimpleCommand simpleCommand; //@Autowired로 처리되는 대상이아니다.
	
	@RequestMapping("/")
	public String goIndex() {
		return"index";
	}
	
	@RequestMapping("simpleListPage")
	public String simpleListPage(Model model) {
		//DI없이 Command를 생성해도 좋다. 스프링 버전에 상관없이 사용가능하다.
		 simpleCommand = new SimpleListCommand();
		 simpleCommand.execute(sqlSession, model);
		return"simple/listPage";
	}
	@RequestMapping("simpleViewPage")
	public String simpleViewPage(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);		
		simpleCommand = new SImpleViewCommand();
		simpleCommand.execute(sqlSession, model);
		return"simple/viewPage";
	}
	
	@RequestMapping(value="simpleupdate", method=RequestMethod.POST)
	public String simpleupdate(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);		
		simpleCommand = new SimpleUpdateCommand();
		simpleCommand.execute(sqlSession, model);
		return"redirect:simpleViewPage";
	}
	
	@RequestMapping(value="simpleDelete", method=RequestMethod.POST)
	public String simpleDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request",request);		
		simpleCommand = new SimpleDeleteCommand();
		simpleCommand.execute(sqlSession, model);
		return"redirect:simpleListPage";
	}
	@RequestMapping("insertPage")
	public String simpleListPage() {		
		return"simple/insertPage";
	}
	
	@RequestMapping(value="simpleInsert", method=RequestMethod.POST)
	public String simpleInsert(RedirectAttributes rttr,
			HttpServletRequest request, Model model) {
		model.addAttribute("rttr",rttr);
		model.addAttribute("request",request);
		simpleCommand = new SimpleInsertCommand();
		simpleCommand.execute(sqlSession, model);
		return"redirect:simpleListPage";
	}
	
	
	
	
	
}
