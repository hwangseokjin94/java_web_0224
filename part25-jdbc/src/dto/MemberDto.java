package dto;
//DTO : DATA TRANSFER OBJECT

import java.sql.Date;

// 동의 어 : VO (VALUE OBJECT), Bean
// 테이블의 행(ROW, RECORD)을 객체로 만든다.
//기본구성
//1.테이블의 칼럼 열(COLUM)과 동일한 필드를 만든다.
//2.GETER와 SETTER를 만든다.

public class MemberDto {
	//Field
	private  int mNo;
	private String mId, mPw, mName, mEmail;
	private Date mRegdate;//sql date 를써야지 됨
	
	//Method
	public int getmNo() {
		return mNo;
	}
	public String getmId() {
		return mId;
	}
	public String getmPw() {
		return mPw;
	}
	public String getmName() {
		return mName;
	}
	public String getmEmail() {
		return mEmail;
	}
	public Date getmRegdate() {
		return mRegdate;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public void setmRegdate(Date mRegdate) {
		this.mRegdate = mRegdate;
	}
	
	
	
	
	
	
	
	
	
	
}





