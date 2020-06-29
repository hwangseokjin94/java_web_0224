package com.koreait.mvc13.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.mvc13.dao.ContactDAO;

public class ContactInsertCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
		Map<String , Object> map =  model.asMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		
		String cName =request.getParameter("cName");
		String cPhone =request.getParameter("cPhone");
		String cAddress =request.getParameter("cAddress");
		String cEmail =request.getParameter("cEmail");
		String cNote =request.getParameter("cNote");
		
		ContactDAO cDAO = new  ContactDAO();
		cDAO.contactInsert(cName, cPhone, cAddress, cEmail, cNote);
		
		

	}

}
