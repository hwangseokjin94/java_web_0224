package com.koreait.mvc08.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	
	//AJAX 통신할때는@ResponseBody 애너테이션 꼭붙인다.
	
	
	@RequestMapping(value="textHandler",produces="text/html;charset=utf-8")
	@ResponseBody //리턴을 response에 담아서 보내라 (리턴은 뷰가아니다.)
	public String text(@RequestParam("sender") String sender) {
		String receiver = "emily";
		String message = receiver +"가"+sender+"에게 응답한다.";
		return message; 
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="jsonHandler",produces="application/json; charset=utf-8")
	@ResponseBody //리턴을 response에 담아서 보내라 (리턴은 뷰가아니다.)	
	public String json(@RequestParam("sender") String sender) {
		String receiver = "samanda";
		JSONObject obj = new JSONObject();
		obj.put("sender", sender);
		obj.put("receiver", receiver);
		
		return obj.toJSONString(); 
	}
	
}












