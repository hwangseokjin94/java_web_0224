package com.koreait.mybatis2.command;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis2.dao.SimpleDAO;
import com.koreait.mybatis2.dto.SimplieDTO;

public class SimpleListCommand implements SimpleCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
	
	SimpleDAO sDAO =sqlSession.getMapper(SimpleDAO.class);
	ArrayList<SimplieDTO> list =sDAO.selectSimpleList();
	model.addAttribute("list",list); 
	model.addAttribute("totalCount",list.size()); 
	
	}

}
