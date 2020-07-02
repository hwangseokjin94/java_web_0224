package com.koreait.mybatis2.dao;

import java.util.ArrayList;

import com.koreait.mybatis2.dto.SimplieDTO;

public interface SimpleDAO {

	//1.전체목록 
	public ArrayList<SimplieDTO> selectSimpleList();
	//2.개별
	public SimplieDTO selectBybNo(int bNo);
	
	//3.수정
	public void updateSimple(String bTitle,String bContent,int bNo);
	//4.삭제
	public void deleteSimple(int bNo);
	//5.삽입
	public int insertSimple(String bWriter ,String bTitle,String bContent);
}
