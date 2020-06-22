package com.koreait.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Student {
	private String name;
	private ArrayList<Integer> scores; //3개의 점수 저장
	private HashSet<String> volunteers; //3개의 봉사활동 저장
	private HashMap<String, String> homeInfo; //두개의 key사용(address, phone)
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, ArrayList<Integer> scores, HashSet<String> volunteers,
			HashMap<String, String> homeInfo) {
		super();
		this.name = name;
		this.scores = scores;
		this.volunteers = volunteers;
		this.homeInfo = homeInfo;
	}

	public void StudentInfo() {
		System.out.println("학생이름"+name);
		System.out.println("학생점수"+scores);
		System.out.println("봉사활동"+volunteers);
		
		for(Map.Entry<String, String> entry : homeInfo.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getScores() {
		return scores;
	}

	public void setScores(ArrayList<Integer> scores) {
		this.scores = scores;
	}

	public HashSet<String> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(HashSet<String> volunteers) {
		this.volunteers = volunteers;
	}

	public HashMap<String, String> getHomeInfo() {
		return homeInfo;
	}

	public void setHomeInfo(HashMap<String, String> homeInfo) {
		this.homeInfo = homeInfo;
	}
	
	
	
	
}
