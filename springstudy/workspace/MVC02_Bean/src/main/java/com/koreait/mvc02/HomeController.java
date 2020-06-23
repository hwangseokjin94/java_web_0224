package com.koreait.mvc02;

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


//@RequestMapping == url-mapping
//메ㅗㅅ드를 대상으로 붙이는 애너테이션
//value = "/" 컨텍스트 패스를 의미한다.
//http://locahost:9090/mvc02 이주소가 입력되면 이메소드를 실행한다.

//method
//RequestMethod.GET : 생력하면 GET방식
//RequestMethod.POST

//home메소드

//1.리턴 : 뷰 이름 만 리턴한다.
//return "home"; /WEB-INF/views/home.jsp로 이동한다.

//2.메소드이름 : home아무이유없음

//3.매개변수
// Model model : request의 attribute 역활을 수행하는 클래스이다.

@Controller //나는 컨트롤러야
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
		return "index";
//		return "home";
	}
	
	//주소창에 http://localhost:9090/mvc02/a/b/c/d/e 가입력되면 view01.jsp이동한다.
	//@RequestMapping(value="/a/b/c/d/e") 아래처럼 value는 생략해도 된다.
	//@RequestMapping("a/b/c/d/e") 시작슬래시 (/)있어도 되고 없어도된다.
	@RequestMapping("/a/b/c/d/e")
	public String goView01() {
		//1.리턴타입  : String ,뷰를 리턴해야하므로
		//2.메소드 이름 :  goView01,아무의미없음
		//3.리턴 return "view01"; 이나 return "/view01";는 차이가없다
		return "view01";
		//return "/view01";
	}
	//http://localhost:9090/mvc02/l/o/g/i/n
	//@RequestMapping("l/o/g/i/n") 시작슬래시 (/)있어도 되고 없어도된다.
	@RequestMapping("/l/o/g/i/n")
	public String gologin() {
		//1.리턴타입  : String ,뷰를 리턴해야하므로
		//2.메소드 이름 :  goView01,아무의미없음
		//3.리턴 return "view01"; 이나 return "/view01";는 차이가없다
		return "member/loginPage";
		//return  "/member/loginPage";
	}
	
	//Model 클래스]
	//1. 스프링 2이전의경우 ModelAndView 라는 클래스를 사용한다.
	//2.request 의 attribute역활을 수행하는 클래스이다.
	//3.addAttribute(속성이름, 값) 방식으로사용한다.
	
	//비교
	//JSP
	// HttpServletRequest request;   request.setAttribute(속성이름 , 값)
	//Spring
	//Model model;  model.addAttribute(속성이름, 값)
	
	//4. Model 은 매개변수로 선언한다.맨마지막 매개변수로 둔다.
	//5.Controller -> view로 이동할때 전달할 값이 있면 무조건 Model을 사용한다.
	
	@RequestMapping("view02")
	public String goView02(Model model) {
		
		model.addAttribute("name","에밀리"); //실제 저장되는곳은 request이다.
		model.addAttribute("age","20");
		return"view02"; // /WEB-INF/views/view02.jsp
	}
	
	//view03.jsp로이동하면
	//PersonDTO , ContactDTO 정보를 확인할수있다.
	
	@RequestMapping("view03")
	public String goView03() {		
		return"view03"; // /WEB-INF/views/view03.jsp
	}
}





