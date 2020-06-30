package com.koreait.mvc14.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.mvc14.dao.ContactDAO;
import com.koreait.mvc14.dto.ContactDTO;

public class ContactViewCommand implements ContactCommand {
	
	@Override
	public void execute(Model model) {
		
		// model 에 저장된 request 를 뺀다.
		// 그러기 위해서 model 을 map 으로 수정한다.
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		
		ContactDAO cDAO = new ContactDAO();
		ContactDTO cDTO = cDAO.selectContactBycNo(cNo);
		
		model.addAttribute("cDTO", cDTO);

	}

}