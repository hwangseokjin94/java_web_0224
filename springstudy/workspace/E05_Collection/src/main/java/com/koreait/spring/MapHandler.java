package com.koreait.spring;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapHandler {

	//Field (property)
	Map<String, String> myMap;
	
	public MapHandler() {}

	//method
	public void mapInfo() {
		//1.1 keySet() + iterator()
		Set<String> set = myMap.keySet();
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			String value = myMap.get(key);
			System.out.println(key+":"+value);
		}
		
		//1.2 keySet() +for
		for(String key : set) {
			String value = myMap.get(key);
			System.out.println(key+":"+value);
		}
		//2.1 Entry
		for(Map.Entry<String, String> entry : myMap.entrySet()) {
			//entry : key:value 로구성
			System.out.println(entry.getKey()+":"+entry.getValue());
		}

	}

	public Map<String, String> getMyMap() {
		return myMap;
	}

	public void setMyMap(Map<String, String> myMap) {
		this.myMap = myMap;
	}
	
	
}
