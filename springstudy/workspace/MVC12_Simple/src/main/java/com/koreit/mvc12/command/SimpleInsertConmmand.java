package com.koreit.mvc12.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.koreit.mvc12.dao.SimpleDAO;
import com.koreit.mvc12.dto.SimplieDTO;

public class SimpleInsertConmmand implements SimpleConmmand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		SimplieDTO sDTO = (SimplieDTO)map.get("sDTO");
		
		SimpleDAO.getInstance().insertSimple(sDTO);

	}

}
