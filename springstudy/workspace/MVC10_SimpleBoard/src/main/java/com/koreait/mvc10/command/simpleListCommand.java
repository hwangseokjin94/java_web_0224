package com.koreait.mvc10.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.koreait.mvc10.dao.SimpleDAO;
import com.koreait.mvc10.dto.SimplieDTO;

public class simpleListCommand implements SimpleConmmand {

	@Override
	public void execute(Model model) {
		
	 ArrayList<SimplieDTO> list = SimpleDAO.getInstance().simpleList();
	 model.addAttribute("list",list);
	 
	}

}
