package com.koreit.mvc12.command;

import org.springframework.ui.Model;

public interface SimpleConmmand {

	public void execute(Model model);
	
}
//controller - > command - > DAO.method - > DB 