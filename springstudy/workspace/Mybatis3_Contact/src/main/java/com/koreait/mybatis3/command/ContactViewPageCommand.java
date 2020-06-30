package com.koreait.mybatis3.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis3.dao.ContactDAO;
import com.koreait.mybatis3.dto.ContactDTO;

public class ContactViewPageCommand implements ContacCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
	Map<String, Object> map =model.asMap();
	HttpServletRequest request = (HttpServletRequest)map.get("request");
	int cNo = Integer.parseInt(request.getParameter("cNo"));
	ContactDAO cDAO = sqlSession.getMapper(ContactDAO.class);
	
	ContactDTO cDTO = cDAO.selectcontactByNo(cNo);
	model.addAttribute("cDTO",cDTO);
	
	}

}
