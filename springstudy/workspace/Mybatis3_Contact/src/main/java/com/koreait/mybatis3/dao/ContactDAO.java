package com.koreait.mybatis3.dao;

import java.util.ArrayList;

import com.koreait.mybatis3.dto.ContactDTO;

public interface ContactDAO {
	//전체조회
	public ArrayList<ContactDTO> selectcontactList();
	//개별조회
	public ContactDTO selectcontactByNo(int cNo);
	//삽입
	public void insertContact(String cName,String cPhone,String cAddress,String cEmail,String cNote);
	//삭제
	public void deletecontactByNo(int cNo);
	
	
}
