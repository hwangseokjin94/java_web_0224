package com.koreait.mybatis3.command;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis3.dao.ContactDAO;
import com.koreait.mybatis3.dto.ContactDTO;

public class ContactListPageCommand implements ContacCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
	
		ContactDAO cDAO =sqlSession.getMapper(ContactDAO.class);
		ArrayList<ContactDTO> list = cDAO.selectcontactList();
		model.addAttribute("list",list);

	}

}
