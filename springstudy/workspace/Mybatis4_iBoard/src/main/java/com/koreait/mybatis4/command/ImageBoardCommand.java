package com.koreait.mybatis4.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface ImageBoardCommand {

	public void execute(SqlSession sqlSession ,Model model);
}
