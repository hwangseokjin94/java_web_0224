package com.koreait.mvc13.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreait.mvc13.dao.ContactDAO;
import com.koreait.mvc13.dto.ContactDTO;

public class ContactViewCommand implements ContactCommand {

	@Override
	public void execute(Model model) {
	
		//model에 저장된 request를 뺀다.
		//그러기 위해서 model을 map으로 수정한다.
		Map<String,Object> map = model.asMap();
		HttpServletRequest request =  (HttpServletRequest)map.get("request");
		
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		ContactDAO cDAO = new ContactDAO();
		ContactDTO cDTO = cDAO.selectContactByNo(cNo);
		
		model.addAttribute("cDTO",cDTO);
		
		

	}

}
