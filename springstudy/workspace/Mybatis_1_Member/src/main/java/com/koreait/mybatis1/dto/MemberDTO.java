package com.koreait.mybatis1.dto;

public class MemberDTO {

	private int mNo;
	private String mId, mName;
	
	public MemberDTO() {}
	public MemberDTO(int mNo, String mId, String mName) {
		super();
		this.mNo = mNo;
		this.mId = mId;
		this.mName = mName;
	}
	
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	
}
