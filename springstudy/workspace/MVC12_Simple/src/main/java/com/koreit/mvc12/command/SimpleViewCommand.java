package com.koreit.mvc12.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreit.mvc12.dao.SimpleDAO;
import com.koreit.mvc12.dto.SimplieDTO;

public class SimpleViewCommand implements SimpleConmmand {

	@Override
	public void execute(Model model) {
	 Map<String, Object> map = model.asMap();
	 HttpServletRequest request = (HttpServletRequest)map.get("request");
	 int bNo = Integer.parseInt(request.getParameter("bNo"));
	 SimplieDTO sDTO = SimpleDAO.getInstance().selectBybNo(bNo);
	 //결과 sDTO를 뷰로 전달하려면 model에 저장해야한단.
	 model.addAttribute("sDTO", sDTO);
	}

}
