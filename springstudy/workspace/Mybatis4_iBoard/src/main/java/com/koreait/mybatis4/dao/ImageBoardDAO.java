package com.koreait.mybatis4.dao;

import java.util.ArrayList;

import com.koreait.mybatis4.dto.ImageboardDTO;

public interface ImageBoardDAO {

	//메소드 이름 = mapper's id
	
	//1.imageBoardInset
	public void imageBoardInset(String iWriter,String iTitle,String iContent,String saveFilename);
	
	//2.selectImageBoardList()
	public ArrayList<ImageboardDTO> selectImageBoardList(); 
}
