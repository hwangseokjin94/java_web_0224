package com.koreait.ex2;

import java.util.Arrays;

public class Student {
	
	// Field
	String name;
	String school;
	int[] score;
	double average;
	boolean isPass;  // 평균 50 이상이면 true
	
	// Constructor
	Student(String _name, String _school) {
		name = _name;
		school = _school;
	}
	
	// Method
	void doExam() {
		score = new int[3];
		int total = 0;
		for (int i = 0; i < score.length; i++) {
			score[i] = (int)(Math.random() * 101);
			total += score[i];
		}
		average = (double)total / score.length;
		isPass = average >= 50;
	}
	void printStudent() {
		System.out.println("이름 : " + name);
		System.out.println("다니는 학교 : " + school);
		System.out.println("점수 : " + Arrays.toString(score));
		System.out.println("평균 : " + average);
		System.out.println(isPass ? "합격" : "불합격");
	}
	
}
