package com.koreit.mvc12.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.koreit.mvc12.dao.SimpleDAO;
import com.koreit.mvc12.dto.SimplieDTO;

public class SimpleUpdateConmmand implements SimpleConmmand {

	@Override
	public void execute(Model model) {
		Map<String ,Object> map = model.asMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		
		SimplieDTO sDTO = new SimplieDTO();
		sDTO.setbNo(Integer.parseInt(request.getParameter("bNo")));
		sDTO.setbTitle(request.getParameter("bTitle"));
		sDTO.setbContent(request.getParameter("bContent"));
		
		SimpleDAO.getInstance().updateSimple(sDTO);
		//수정이완려되면 @RequestMapping ("view")로이동한다.
		//view로 이동할떄는 bNo를 전달해야하므로
		//1.view?bNo = 같은 파라미터넘기던가
		//2.model에 bNo를 담아둔다.
		
		model.addAttribute("bNo",sDTO.getbNo());
		
		// 번외.
		// 곧바로 viewPage 로 이동할 수 있도록
		// 수정된 sDTO를 DB에서 가져온 뒤 전달하는 방식으로도 풀 수 있다.
		// model.addAttribute("sDTO", SimpleDAO.getInstance().selectBybNo(Integer.parseInt(request.getParameter("bNo"))));
		// 컨트롤러에서는 return "simple/viewPage"; 방식으로 이동.

	}

}
