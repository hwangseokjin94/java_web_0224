package com.koreait.mvc10.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.mvc10.dao.SimpleDAO;

public class SimpleInsertCommand implements SimpleConmmand {

	@Override
	public void execute(Model model) {
		
		//modle에 저장된 request를 꺼내자.
		 Map<String, Object> map = model.asMap(); //model을 Map구조로 바꾼다.
		 HttpServletRequest request =(HttpServletRequest) map.get("req");
	
		 String bWriter = request.getParameter("bWriter");
		 String bTitle = request.getParameter("bTitle");
		 String bContent = request.getParameter("bContent");
		 
		 SimpleDAO.getInstance().simpleInsert(bWriter, bTitle, bContent);
		 
	}

}
