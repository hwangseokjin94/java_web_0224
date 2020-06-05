package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlackDAO;
import dto.BlackDTO;

public class ListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// DAO 의 selectList()메소드 호출 메소드 호출해서 전체 데이터를 가져온다.
		//List에 보관한다.
		BlackDAO bDao = BlackDAO.getInstance();
		List<BlackDTO> list =bDao.selectList();
		
		//r결과  list를 request에 담아둔ㄷ.
		request.setAttribute("LIST",list);
		
		//응답 뷰
		return "listPage.jsp";
	}

}
