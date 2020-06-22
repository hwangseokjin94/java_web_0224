package com.koreait.spring;

import java.util.HashMap;

public class Police {
	
	private String name;
	private HashMap<String, String> deptInfo;
	private Gun pistol;
	
	public Police() {}
	public Police(String name, HashMap<String, String> deptInfo, Gun pistol) {
		super();
		this.name = name;
		this.deptInfo = deptInfo;
		this.pistol = pistol;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, String> getDeptInfo() {
		return deptInfo;
	}
	public void setDeptInfo(HashMap<String, String> deptInfo) {
		this.deptInfo = deptInfo;
	}
	public Gun getPistol() {
		return pistol;
	}
	public void setPistol(Gun pistol) {
		this.pistol = pistol;
	}
	
}
