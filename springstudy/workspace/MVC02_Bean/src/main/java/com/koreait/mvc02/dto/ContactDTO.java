package com.koreait.mvc02.dto;

public class ContactDTO {

	private String phone;
	private String addr;
	
	public ContactDTO() {}
	public ContactDTO(String phone, String addr) {
		super();
		this.phone = phone;
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
}
