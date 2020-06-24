package com.koreia.mvc06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreia.mvc06.memberDTO.MemberDTO;

@Controller
public class MemberController {

	
	@RequestMapping("index") //location.href='index'에 의해서 찾아온곳
	public String goIndex() { 
		return"index"; // /WEB-INF/views/index.jsp로 이동
	}
	@RequestMapping(value = "member/login", method = RequestMethod.GET)
	public String goLoginResult(@RequestParam("id") String id,
								@RequestParam("pw") String pw, Model model) {
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		return"member/loginResult";
	}
	@RequestMapping(value = "member/login1", method = RequestMethod.GET)
	public String goLoginResult1(MemberDTO mDTO, Model model) {	
		model.addAttribute("mDTO",mDTO);
		
		return"member/loginResult1";
	}
}
