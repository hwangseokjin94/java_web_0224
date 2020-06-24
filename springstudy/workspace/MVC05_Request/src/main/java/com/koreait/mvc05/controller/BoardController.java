package com.koreait.mvc05.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.mvc05.dto.BoaredDTO;

@Controller
@RequestMapping("board")
public class BoardController {

	@RequestMapping("v01")
	public String goView01(HttpServletRequest request,Model model) {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int hit = Integer.parseInt(request.getParameter("hit") );
		
		model.addAttribute("title",title);
		model.addAttribute("content",content);
		model.addAttribute("hit",hit);

		return "board/view01";
	}
	
	
	@RequestMapping("v02")
	public String goView02(@RequestParam("title") String title,
							@RequestParam("content") String content,
							@RequestParam("hit") int hit,Model model){
		


		model.addAttribute("title",title);
		model.addAttribute("content",content);
		model.addAttribute("hit",hit);
		
		return "board/view02";
	}
	
	@RequestMapping("v03")
	public String goView03(@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam("hit") int hit,Model model){
		
		BoaredDTO bDTO = new BoaredDTO();
		bDTO.setContent(content);
		bDTO.setHit(hit);
		bDTO.setTitle(title);
		
		model.addAttribute("bDTO",bDTO);
		
		return "board/view03";
	}
	
	@RequestMapping("v04")
	public String goView03(BoaredDTO bDTO,Model model){
		
		model.addAttribute("bDTO",bDTO);
		
		return "board/view04";
	}
	
	//model에 pDTO라고 싣어
	@RequestMapping("v05")
	public String goView05(@ModelAttribute("bDTO") BoaredDTO bDTO) {
		
		return "board/view05";
		
	}
	
	

	
}
