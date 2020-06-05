package command;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dto.DTO;

/*
 * 	FROM CONTROLLER :request 받아온다.
 * 	TO CONTROLLER : 응답 VIEW를 리턴한다.
 *  
 * */


public class ViewCommand {
	public String  execute(HttpServletRequest request , HttpServletResponse response) {
		//request - > DTO 변환해서 request 에 저장한다.
		DTO dto = new DTO();
		dto.setName(request.getParameter("name"));
		dto.setAge(Integer.parseInt(request.getParameter("age")));
		dto.setPhone(request.getParameter("phone"));
		dto.setAddress(request.getParameter("address"));
		dto.setGender(request.getParameter("gender"));
		dto.setMemo(request.getParameter("memo"));
		dto.setDate(new Date(System.currentTimeMillis()));
		request.setAttribute("DTO", dto);
		
		//DTO를  session에 담기 
		//세션은 jsp... 자바에서 리퀘스터 어케쓰냐 ..? 선언했으니까~~~
		//뤼케스트랑 세션이랑 똑같이 이름을 부여가 되지만 스코프 문제도있고 ㄱ 헷갈리니 ...
		HttpSession session = request.getSession();
		session.setAttribute("SDTO", dto);
		
		//DTO를 map에담기
		Map<String, DTO> map =  new HashMap<String, DTO>();
		map.put("MDTO", dto);
		request.setAttribute("MAP", map);
		
		//응답VIEW리턴하기
		return "output.jsp";
	}
}
