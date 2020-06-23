package com.koreait.mvc3;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

/**
 * Handles requests for the application home page.
 */
@Controller
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
	
	//ModelAndView 클래스
	//1.스프링 2이전에 사용된 클래스로 현재 많이 생산된코드이다.
	//2.앞으로 새로 만들때는 사용하지않는다.
	//3.Model 과 View(jsp)를 모두 저장한다.
	//4.Model 에 attribute 추가 : addObject()
	//5. View 추가: setViewName()
	
	//http://localhost:9090/mvc3/v01
	@RequestMapping("v01") //실제 이동할페이지와 Mapping값이 일치하지않기때문에 보안에 유리하다.
	public ModelAndView goview(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view01"); //WEB-INF/views/board/view01.jsp
		return mav;
	}
	@RequestMapping("v02")
	public ModelAndView goview2() {
		ModelAndView mav =new ModelAndView();
		mav.addObject("name", "빈지노");
		mav.addObject("age", 27);
		mav.setViewName("board/view02");
		return mav;
	}
	
	
	
}
