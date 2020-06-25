package com.koreait.mvc11.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.koreait.mvc11.dao.SimpleDAO;
import com.koreait.mvc11.dto.SimplieDTO;

public class SimpleListCommand implements SimpleConmmand {

	@Override
	public void execute(Model model) {
		ArrayList<SimplieDTO> list = SimpleDAO.getInstance().selectSimpleList();
		model.addAttribute("list",list);
	}

}
