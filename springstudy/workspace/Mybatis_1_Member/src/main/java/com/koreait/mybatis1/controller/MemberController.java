package com.koreait.mybatis1.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.mybatis1.dao.MemberDAO;
import com.koreait.mybatis1.dto.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/")
	public String goIndex() {
		return "index";
	}
	@RequestMapping("listPage")
	public String listPage(Model model) {
		MemberDAO mDAO = sqlSession.getMapper(MemberDAO.class);
		model.addAttribute("list",mDAO.selectMemberList());
		return "member/listPage";
	}
	@RequestMapping("insertPage")
	public String insertPage() {
		return "member/insertPage";
	}
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insert(@RequestParam("mId") String mId,@RequestParam("mName") String mName) {
		MemberDAO mDAO = sqlSession.getMapper(MemberDAO.class);
		mDAO.insertMember(mId, mName);
		return "redirect:listPage";
	}
	
	@RequestMapping("viewPage")
	public String viewPage(@RequestParam("mNo") int mNo, Model model) {
		MemberDAO mDAO = sqlSession.getMapper(MemberDAO.class);
		MemberDTO mDTO =mDAO.selectByNo(mNo);
		model.addAttribute("mDTO",mDTO);
		return "member/viewPage";
	}
	@RequestMapping("update")
	public String update(@RequestParam("mName") String mName, @RequestParam("mNo") int mNo, Model model) {
		MemberDAO mDAO = sqlSession.getMapper(MemberDAO.class);
		mDAO.updateMember(mName, mNo);		
		model.addAttribute("mNo",mNo);
		return "redirect:viewPage";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String delete(@RequestParam("mNo") int mNo) {
		MemberDAO mDAO = sqlSession.getMapper(MemberDAO.class);
		mDAO.deleteMember(mNo);
		return "redirect:listPage";
	}
	
}
