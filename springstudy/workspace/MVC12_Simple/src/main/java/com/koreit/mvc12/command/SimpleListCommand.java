package com.koreit.mvc12.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.koreit.mvc12.dao.SimpleDAO;
import com.koreit.mvc12.dto.SimplieDTO;

public class SimpleListCommand implements SimpleConmmand {

	@Override
	public void execute(Model model) {
		ArrayList<SimplieDTO> list = SimpleDAO.getInstance().selectSimpleList();
		model.addAttribute("list",list);
	}

}
