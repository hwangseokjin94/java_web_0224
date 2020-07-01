package com.koreait.mybatis4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.mybatis4.command.ImageBoardListCommand;
import com.koreait.mybatis4.command.ImageBoardMultiUploadCommand;
import com.koreait.mybatis4.command.ImageBoardSingleUploadCommand;
import com.koreait.mybatis4.command.EmailAuthCommand;
import com.koreait.mybatis4.command.ImageBoardCommand;
import com.koreait.mybatis4.command.ImageBoardDownloadCommand;

@Controller
public class ImageBoardController {
	
	//field
	@Autowired
	private SqlSession sqlSession;
	
	private ImageBoardCommand imageboardCommand;
	
	
	@RequestMapping("/")
	public String goIndex() {
		return"index";
	}
	@RequestMapping("uploadPage")
	public String goUploadPage() {
		return"uploadPage";
	}
	
	@RequestMapping(value="singleUpload",method=RequestMethod.POST)
	public String singleUpload(MultipartHttpServletRequest mr , Model model) {
		
		//1.업로드 없는 경우:HttpServletRequest request 
		//2.업로드 있는경우 :MultipartHttpServletRequest mr
		
		model.addAttribute("mr",mr);
		imageboardCommand = new ImageBoardSingleUploadCommand();
		imageboardCommand.execute(sqlSession, model);
		
		return"redirect:imageBoardListPage";
	}
	@RequestMapping("imageBoardListPage")
	public String imageBoardListPage(Model model) {
		imageboardCommand = new ImageBoardListCommand();
		imageboardCommand.execute(sqlSession, model);
		return"imageBoardListPage";
	}
	@RequestMapping(value="multiUpload",method=RequestMethod.POST)
	public String multiUpload(MultipartHttpServletRequest mr , Model model) {
		
		//1.업로드 없는 경우:HttpServletRequest request 
		//2.업로드 있는경우 :MultipartHttpServletRequest mr
		
		model.addAttribute("mr",mr);
		imageboardCommand = new ImageBoardMultiUploadCommand();
		imageboardCommand.execute(sqlSession, model);
		
		return"redirect:imageBoardListPage";
	}
	@RequestMapping("download")
	public void download(HttpServletRequest request,HttpServletResponse response, Model model) {
		
		model.addAttribute("request",request);
		model.addAttribute("response",response); //파일다운로드는 response
		imageboardCommand = new ImageBoardDownloadCommand();
		
		imageboardCommand.execute(sqlSession, model);
	}
	
	
	//↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓이메일
	@Autowired
	private JavaMailSender mailSender; //root-context.xml의 빈 자동 생성
	
	
	@RequestMapping("emailAuth")
	public String emailAuth(HttpServletRequest request, Model model) {
		
		model.addAttribute("request",request);
		model.addAttribute("mailSender",mailSender);
		
		imageboardCommand = new EmailAuthCommand();
		imageboardCommand.execute(sqlSession, model);
		return "emailAuthConfirm"; //이메일 인증코드를 emailAuthConfirm.jsp로 보내준다.
	}
	
}

