package com.koreait.mvc05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.mvc05.dto.PersonDTO;

@Controller
public class MyController {
	//아래4개 애노테이션 다같음
	//@RequestMapping(value="member/v01")
	//@RequestMapping(value="/member/v01")
	//@RequestMapping("/member/v01")
	//@RequestMapping("member/v01")
	

	@RequestMapping("member/v01")
	public String goView01(HttpServletRequest request, Model model) {

		//request : 다른곳 - > 컨트롤러로 덪ㄴ달되는 데이터를 저장한다.
		//Model : 컨트롤러 -> 뷰(jsp) 로 전달하는 데이터를 저장한다. request에 attribute타입으로 전달한다.
		
		//컨트롤러 입장
		//request : 받는값
		//Model : 주는값
		
		String name = request.getParameter("name");
		int age =Integer.parseInt( request.getParameter("age"));
		
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		return "member/view01"; //WEB-INF/views/member/view01.jsp
		
	}
	
	//2.Spring 스타일
	//@RequestParam(파라미터) 저장할 변수 선언
	//@RequestParam("name") String name
	//@RequestParam("age") int age
	
	@RequestMapping("member/v02")
	public String goView02(@RequestParam("name") String name,
						  @RequestParam("age") int age,  Model model) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		
		return "member/view02";
		
	}
	@RequestMapping("member/v03")
	public String goView03(@RequestParam("name")String name,
					@RequestParam("age")int age ,Model model) {
		PersonDTO pDTO = new PersonDTO();
		pDTO.setName(name);
		pDTO.setAge(age);
		
		model.addAttribute("pDTO",pDTO);
		return "member/view03";
		
	}
	//스프링은 객체로 다받아버림 쪼개서던젔는데 DTO로 해결해보리기
	@RequestMapping("member/v04")
	public String goView04(PersonDTO pDTO, Model model) {
		model.addAttribute("pDTO",pDTO);
		return "member/view04";
		
	}
	
	//model에 pDTO라고 싣어
	@RequestMapping("member/v05")
	public String goView05(@ModelAttribute("pDTO") PersonDTO pDTO) {
		
		return "member/view05";
		
	}
	
	
}
















