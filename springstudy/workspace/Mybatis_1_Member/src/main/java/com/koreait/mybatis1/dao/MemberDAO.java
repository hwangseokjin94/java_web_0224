package com.koreait.mybatis1.dao;

import java.util.ArrayList;

import com.koreait.mybatis1.dto.MemberDTO;

public interface MemberDAO {

	//DAO는 인터페이스이다.
	
	//DAO와 mapper는 직접 연결된다.
	//DAO의 메소드명이 mapper의 id가된다.
	public ArrayList<MemberDTO> selectMemberList();
	
	//2.삽입하기
	public void insertMember(String mId,String mName);
	//mapper #{param1}#{param2}
	
	//3.회원정보기
	public MemberDTO selectByNo(int mNo);
	//4.수정하기
	public void updateMember(String mName,int mNo);
	public void deleteMember(int mNo);
	
}
