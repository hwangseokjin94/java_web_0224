package com.koreait.ex1;

import java.util.Arrays;
import java.util.Random;

// 데이터클래스 Student
class Student {
	
	// Field
	String name;
	String school;
	int[] score;
	double average;
	boolean isPass;  // 평균 50 이상이면 true
	
	// Constructor
	Student(String _name , String _school) {
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

public class Ex06_Student {

	public static void main(String[] args) {
		
		Student stu = new Student("제임스", "서강대");
		
		stu.doExam();  // score 3개를 0 ~ 100 사이 랜덤 생성
		stu.printStudent();  // 이름, 학교, 점수 3개, 평균, 합격/불합격

	}

}
