package com.koreait.mvc09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OperationController {

	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	
	@RequestMapping("add")
	public String goAdd(@RequestParam("a") int a,@RequestParam("b") int b,Model model) {
		String op = "+";
		String signal = "뺄셈";
		String signal2 = "subtract";
		String message="버튼을누르면 뺄셈입니다";
		int result = a+b;
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		model.addAttribute("op",op);
		model.addAttribute("signal2",signal2);
		model.addAttribute("signal",signal);
		model.addAttribute("result",result);
		model.addAttribute("message",message);
		

		return "output";
	}
	
	@RequestMapping("subtract")
	public String gosubtract(@RequestParam("a") int a,@RequestParam("b") int b,Model model) {
		String op = "-";
		String signal = "곱하기";
		String signal2 = "multiply";
		String message="버튼을누르면 곱셈입니다.";
		int result = a-b;
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		model.addAttribute("op",op);
		model.addAttribute("signal2",signal2);
		model.addAttribute("signal",signal);
		model.addAttribute("result",result);
		model.addAttribute("message",message);
		
		return "output";
	}
	
	@RequestMapping("multiply")
	public String gomultiply(@RequestParam("a") int a,@RequestParam("b") int b,Model model) {
		String op = "*";
		String signal = "나누기";
		String signal2 = "division";
		String message="버튼을누르면 나눗셈입니다.";
		int result = a*b;
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		model.addAttribute("op",op);
		model.addAttribute("signal2",signal2);
		model.addAttribute("signal",signal);
		model.addAttribute("result",result);
		model.addAttribute("message",message);
		return "output";
	}
	@RequestMapping("division")
	public String godivision(@RequestParam("a") int a,@RequestParam("b") int b,Model model) {
		String op = "/";
		String signal = "초기화면";
		String signal2 = "main";
		String message="버튼을누르면 초기화면입니다.";
		double result = a/b;
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		model.addAttribute("op",op);
		model.addAttribute("signal2",signal2);
		model.addAttribute("signal",signal);
		model.addAttribute("result",result);
		model.addAttribute("message",message);
		return "output";
	}

	@RequestMapping("main")
	public String goIndex2() {
		return "index";
	}
	
	
	
}
