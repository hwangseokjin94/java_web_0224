package com.koreait.mvc10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvc10.command.SimpleConmmand;
import com.koreait.mvc10.command.SimpleDeleteCommand;
import com.koreait.mvc10.command.SimpleInsertCommand;
import com.koreait.mvc10.command.SimpleUpdateCommand;
import com.koreait.mvc10.command.SimpleViewCommand;
import com.koreait.mvc10.command.simpleListCommand;

@Controller
public class SimpleController {
	//field
	private SimpleConmmand command;
	
	@RequestMapping("/")
	public String goIndex() {
		return"index";
	}
	@RequestMapping("list")
	public String golist(Model model) {
		//DB에서 list가져오기
		//list를 simple/listPage.jsp에 전달하기 (model이list를 전달하는 역활이다.)
		
		command = new simpleListCommand();
		command.execute(model);
		
		return "simple/listPage";
		
	}
	
	@RequestMapping("insertPage")
	public String goInsertPage() {
		return "simple/insertPage";
	}
	@RequestMapping("insert")
	public String doInsert(HttpServletRequest request,Model model) {
		//1.insertPage.jsp에서 넘오온 입력갑 파라미터는 request에 저장되어있다.
		//2.이 request를 simpleInsertCommand에 전달하기 위해 Model에저장한다.
		//(모든 simpleInsertCommand 는 Model만 받을수있게 되어있다.
		model.addAttribute("req",request);
		command = new SimpleInsertCommand();
		command.execute(model);
		
		return "redirect:list";//@RequestMapping("list")
		//redirect 다음에는 맵핑값으렂ㄱ어줘야된다!! 뷰페이지가아니라!!!!
	}
	
	@RequestMapping("view")
	public String goView(HttpServletRequest request , Model model) {
		
    	// HttpServletRequest request : <a href="view?bNo=${sDTO.bNo }">를통해 전달되는 파라미터 bNo를 저장하고있다.
		//SimpleViewCommand 에게 전달한 request를 model에 저장한다.
		//SimpleViewCommand 는 model만받을수있기때문
		model.addAttribute("request",request);
		command = new SimpleViewCommand();
		command.execute(model);
		return"simple/viewPage";
		
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(HttpServletRequest request , Model model) {
		model.addAttribute("request",request);
		command = new SimpleUpdateCommand();
		command.execute(model);
		
		return"redirect:view?bNo="+request.getParameter("bNo");
		
		//redirect 못넘김 
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String delete(HttpServletRequest request , Model model) {
		model.addAttribute("request",request);
		command = new SimpleDeleteCommand();
		command.execute(model);
		
		return"redirect:list";
		
	 
	}
	
	
	
	
	
	
	
	
}













