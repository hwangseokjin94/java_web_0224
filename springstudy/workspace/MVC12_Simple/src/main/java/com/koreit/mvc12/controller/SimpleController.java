package com.koreit.mvc12.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreit.mvc12.command.SimpleConmmand;
import com.koreit.mvc12.command.SimpleDeleteConmmand;
import com.koreit.mvc12.command.SimpleInsertConmmand;
import com.koreit.mvc12.command.SimpleListCommand;
import com.koreit.mvc12.command.SimpleUpdateConmmand;
import com.koreit.mvc12.command.SimpleViewCommand;
import com.koreit.mvc12.config.AnnoCTX;
import com.koreit.mvc12.dto.SimplieDTO;

@Controller
public class SimpleController {

	//Field
	private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoCTX.class);
	
	
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	
	
	
	@RequestMapping("list")
	public String list(Model model) {
		SimpleConmmand simpleListCommand = ctx.getBean("simpleListCommand",SimpleListCommand.class);
		simpleListCommand.execute(model);
		return "simple/listPage";
	}
	@RequestMapping("view")
	public String view(HttpServletRequest request, Model model) {
		SimpleConmmand simpleViewCommand =ctx.getBean("simpleViewCommand",SimpleViewCommand.class);
		model.addAttribute("request",request);
		simpleViewCommand.execute(model);
		return "simple/viewPage";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, Model model) {
		SimpleConmmand  simpleUpdateConmmand = ctx.getBean("simpleUpdateConmmand",SimpleUpdateConmmand.class);
		model.addAttribute("request",request);
		simpleUpdateConmmand.execute(model);
		return "redirect:view";
		
		
	}
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request, Model model) {
		SimpleConmmand  simpleDeleteConmmand = ctx.getBean("simpleDeleteConmmand",SimpleDeleteConmmand.class);
		model.addAttribute("request",request);
		simpleDeleteConmmand.execute(model);
		return "redirect:list";
		
		
	}
	@RequestMapping("insertPage")
	public String goInsertPage() {
		return"simple/insertPage";
	}
	@RequestMapping("insert")
	public String insert(SimplieDTO sDTO, Model model) {
		SimpleConmmand  simpleInsertConmmand = ctx.getBean("simpleInsertConmmand",SimpleInsertConmmand.class);
		model.addAttribute("sDTO",sDTO);
		simpleInsertConmmand.execute(model);
		return "redirect:list";
		
		
	}
	
	
}













