package com.koreait.spring;

import java.util.List;

public class ListHandler {
	
	//Field(property)
	private List<String> list;
	
	//Constructor
	public ListHandler() {}
	
	//Method
	public void listInfo() {
		for(int i = 0 ,len = list.size(); i <len ; i ++) {
			System.out.println(i+"번쨰요소 :  "+list.get(i));
		}
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	
	
}
