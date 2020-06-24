package com.koreia.mvc06.memberDTO;

public class MemberDTO {
	
	private String id;
	private String pw;
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
