package com.koreait.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;



@Configuration
public class Police {
	private String name;

	private HashMap<String, String> deptInfo;

	private Gun pistol;

	public Police() {
		// TODO Auto-generated constructor stub
	}
	

	public void policeMainInfo() {
	
		System.out.println("이름"+ name);
		for(Map.Entry<String, String> entry : deptInfo.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		System.out.println("권총"+pistol.getModel());
		System.out.println("현재총알수:"+pistol.getBullet());
		
	}
	
	
	
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
