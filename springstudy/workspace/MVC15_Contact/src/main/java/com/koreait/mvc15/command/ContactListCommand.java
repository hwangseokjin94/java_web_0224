package com.koreait.mvc15.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.koreait.mvc15.dao.ContactDAO;
import com.koreait.mvc15.dto.ContactDTO;

public class ContactListCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		
		ContactDAO cDAO = new ContactDAO();
		ArrayList<ContactDTO> list= cDAO.selectContactList();
		model.addAttribute("list", list);
	
	}

	
	
	
}
