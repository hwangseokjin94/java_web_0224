package com.koreait.mybatis4.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.mybatis4.dao.ImageBoardDAO;

public class ImageBoardListCommand implements ImageBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		ImageBoardDAO iDAO = sqlSession.getMapper(ImageBoardDAO.class);
		model.addAttribute("list",iDAO.selectImageBoardList());
		
	}

}
