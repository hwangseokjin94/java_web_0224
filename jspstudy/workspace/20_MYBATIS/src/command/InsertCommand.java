package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlackDAO;
import dto.BlackDTO;

public class InsertCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
			//request -> DTO 변환해야한다.
		BlackDTO bDto = new BlackDTO();
		bDto.setTitle(request.getParameter("title"));
		bDto.setContent(request.getParameter("content"));
		
		//DTO -> DAO의  insertDTO()메소드로 전달해야한다.		
		BlackDAO bDao = BlackDAO.getInstance();
		bDao.insertDTO(bDto);
		
		//결과저장 request ㄸ는 session에한다(이문제는 생략)
		
		//응답 VIEW리턴한다.		
		return "index.jsp";
	}

}
