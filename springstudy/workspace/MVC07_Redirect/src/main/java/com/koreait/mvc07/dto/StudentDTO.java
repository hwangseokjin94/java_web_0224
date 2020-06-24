package com.koreait.mvc07.dto;

public class StudentDTO {
	
	private String name;
	private String dept;
	private int stuNo;
	
	public StudentDTO() {}
	
	public StudentDTO(String name, String dept, int stuNo) {
		super();
		this.name = name;
		this.dept = dept;
		this.stuNo = stuNo;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	
	
}
