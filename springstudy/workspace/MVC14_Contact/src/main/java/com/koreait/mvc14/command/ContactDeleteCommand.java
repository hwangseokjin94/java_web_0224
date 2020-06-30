package com.koreait.mvc14.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.mvc14.dao.ContactDAO;

public class ContactDeleteCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		
		ContactDAO cDAO = new ContactDAO();
		cDAO.contactDelete(cNo);
		
	}

}
