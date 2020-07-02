package com.koreait.mybatis2.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mybatis2.dao.SimpleDAO;

public class SimpleInsertCommand implements SimpleCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
			Map<String, Object> map =model.asMap();
			RedirectAttributes rttr= (RedirectAttributes)map.get("rttr");
			HttpServletRequest request =(HttpServletRequest)map.get("request");
			
			String bWriter = request.getParameter("bWriter");
			String bTitle = request.getParameter("bTitle");
			String bContent = request.getParameter("bContent");
			
			SimpleDAO sDAO =sqlSession.getMapper(SimpleDAO.class);
			//삽입결과를 redirect로 넘기기떄문에
			//model을이용하면 중간에 넘긴값이사라지낟.
			//그래서 model대신rttr을 사용한다.
			rttr.addFlashAttribute("insertResult",sDAO.insertSimple(bWriter, bTitle, bContent));
			
			//삽입결과를 listPage.jsp에넘기는데
			//삽입후 listPage.jsp 에서 삽입결과를 검사할수있도록
			//삽입후에 이동한것이라는 "변수" 를 하나 더 넘겨준다.
			rttr.addFlashAttribute("beInserted",true);
	}

}
