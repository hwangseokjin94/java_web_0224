package com.koreait.mvc14.dto;

public class ContactDTO {
	
	private int cNo;
	private String cName, cPhone, cAddress ,cEmail, cNote;
	public ContactDTO() {
		// TODO Auto-generated constructor stub
	}
	public ContactDTO(int cNo, String cName, String cPhone, String cAddress, String cEmail, String cNote) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.cPhone = cPhone;
		this.cAddress = cAddress;
		this.cEmail = cEmail;
		this.cNote = cNote;
	}
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcNote() {
		return cNote;
	}
	public void setcNote(String cNote) {
		this.cNote = cNote;
	}
	
	
}
