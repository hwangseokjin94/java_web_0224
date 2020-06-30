package com.koreait.mvc14.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.koreait.mvc14.dao.ContactDAO;
import com.koreait.mvc14.dto.ContactDTO;

public class ContactListViewCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		ContactDAO cDAO = new ContactDAO();
		ArrayList<ContactDTO> list= cDAO.selectContactList();
		model.addAttribute("list",list);

	}

}
