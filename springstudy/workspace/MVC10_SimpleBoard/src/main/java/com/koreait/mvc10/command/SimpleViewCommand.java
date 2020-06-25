package com.koreait.mvc10.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.mvc10.dao.SimpleDAO;
import com.koreait.mvc10.dto.SimplieDTO;

public class SimpleViewCommand implements SimpleConmmand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int bNo= Integer.parseInt(request.getParameter("bNo"));
		
		SimplieDTO sDTO =	SimpleDAO.getInstance().simpleView(bNo);
		
		//뷰에 젖달할 데이터는 model에 저장한다.
		model.addAttribute("sDTO",sDTO);
		
			
	}

}
