package com.koreait.mvc07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mvc07.dto.StudentDTO;

@Controller
public class StudentController {

	@RequestMapping(value="v01",method = RequestMethod.GET)
	public String goView01(StudentDTO sDTO, Model model) {
		//포어드 (forward)
		model.addAttribute("sDTO",sDTO);
		return "student/result01";
	}
	
	@RequestMapping(value="v02",method = RequestMethod.POST)
	public String goView02(StudentDTO sDTO,RedirectAttributes rttr) {
		//리다이렉트 (redirect)
		//RedirectAttributes 클래스의 addFlashAttribute 메소드를 통해서
		//리다이렉트 할떄 값을 넘길수있따. (Model대신사용)
		rttr.addFlashAttribute("sDTO",sDTO);
		
		return "redirect:v02_again"; //redirect :RequestMapping값
	}
//리다이렉트는 정보안넘어감? 파라미터에 붙였음 page
	
	@RequestMapping("v02_again")
	public String goView02_again(){
		return "student/result02";
	}
	
}
