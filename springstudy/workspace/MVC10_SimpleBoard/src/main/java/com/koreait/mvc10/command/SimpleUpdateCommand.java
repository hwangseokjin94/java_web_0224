package com.koreait.mvc10.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.mvc10.dao.SimpleDAO;

public class SimpleUpdateCommand implements SimpleConmmand {

	@Override
	public void execute(Model model) {
	
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
	
		int bNo= Integer.parseInt(request.getParameter("bNo"));
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		SimpleDAO.getInstance().simpleUpdate(bNo, bTitle, bContent);
		
		
	}

}
