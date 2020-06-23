package com.koreait.mvc4;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller

@RequestMapping("/member")//이컨트롤러에 있는 모든 requestMappin은 "/member"로 시작한다.
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// RequestMapping 컨트롤러 전체에 "prefix"값으로 "/member"가존재하고있다.
	//따라서 아래 RequestMapping은 다음과 같은 주소를 가지게 된다.
	//http://localhost:9090/mvc4/member/v01
	
	//@RequestMapping("/v01") 와 @RequestMapping("v01") 는차이가없다
	//form 에서 데이터를 넘기는 경우에는 슬래시(/)로 시작하는 Mapping을 사용할수 없다.
	//슬래시가없는  @RequestMapping("v01") 위주로 사용하장
	
	//이동할 경로와 Mapping값이 일치할 필요는 없다.
	//일치하지 않으면 보안에 도움이된다.
	//이동할 경로와 Mapping 값을 일치시켜도 상관없다.
	//포어드
	@RequestMapping("v01")
	public String goView01() {
		return"view01"; // WEB-INF/views/view01.jsp
	}
		
	
}
