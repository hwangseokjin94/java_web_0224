package com.koreit.mvc12.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreit.mvc12.dao.SimpleDAO;

public class SimpleDeleteConmmand implements SimpleConmmand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request =(HttpServletRequest) map.get("request");
		
		int bNo =Integer.parseInt(request.getParameter("bNo"));
		
		SimpleDAO.getInstance().deleteSimple(bNo);
	}

}
