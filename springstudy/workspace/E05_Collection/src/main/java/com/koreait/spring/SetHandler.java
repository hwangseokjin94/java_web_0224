package com.koreait.spring;

import java.util.Iterator;
import java.util.Set;

public class SetHandler {

	//Field (property)
	
	private Set<String> mySet;
	
	//Constructor
	public SetHandler() {
	}
	
	public void setInfo() {
		Iterator<String> itr = mySet.iterator();
		while(itr.hasNext()) { //요소가 남아있으면,
			System.out.println(itr.next()); //그요소를 꺼낸ㄴ
		}
	}

	public Set<String> getMySet() {
		return mySet;
	}

	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}
	 
}
