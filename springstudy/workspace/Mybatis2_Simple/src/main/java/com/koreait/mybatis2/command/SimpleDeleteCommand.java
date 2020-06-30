package com.koreait.mybatis2.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis2.dao.SimpleDAO;

public class SimpleDeleteCommand implements SimpleCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map =model.asMap();
		HttpServletRequest request =(HttpServletRequest)map.get("request");
		
		
			int bNo = Integer.parseInt(request.getParameter("bNo"));
			
			SimpleDAO sDAO =sqlSession.getMapper(SimpleDAO.class);
			sDAO.deleteSimple(bNo);

		

	}

}
