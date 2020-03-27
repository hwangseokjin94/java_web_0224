package com.koreait.ex;

import java.text.DecimalFormat;
import java.util.Arrays;

// 데이터클래스 Student
class Student {
	
	// Field
	String name;
	String school;
	int[] score;
	double average;
	boolean isPass;
	
	// Constructor
	Student(String name, String school) {
		this.name = name;
		this.school = school;
	}
	
	// Method
	void doExam() {
		score = new int[3];
		for (int i = 0; i < score.length; i++) {
			score[i] = (int)(Math.random() * 101);
		}
		average = getAverage();
		isPass = getPass();
	}
	boolean getPass() {
		return average >= 50;
	}
	double getAverage() {
		int total = 0;
		for (int i = 0; i < score.length; i++) {
			total += score[i];
		}
		return (double)total / score.length;
	}
	void printStudent() {
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.print("이름 : " + name + "(" + school + "), ");
		System.out.println("성적 : " + Arrays.toString(score) + ", 평균 : " + df.format(average) + "점(" + (isPass ? "합격" : "불합격") + ")");
	}
	
}

// 데이터클래스 Lecture
class Lecture {
	
	// Field
	String lectureName;
	Student[] students;
	int idx;
	
	// Constructor
	Lecture(String lectureName, int count) {
		this.lectureName = lectureName;
		students = new Student[count];
	}
	
	// Method
	void addStudent(Student stu) {
		students[idx++] = stu;  // idx : 인덱스 (추가된 학생 수)
	}
	void doExam() {
		for (int i = 0; i < idx; i++) {
			students[i].doExam();
		}
	}
	double getLectureAverage() {
		double total = 0;
		for (int i = 0; i < idx; i++) {
			total += students[i].getAverage();
		}
		return total / idx;
	}
	void printLecture() {
		System.out.println("강의명 : " + lectureName);
		System.out.println("강의 평균 : " + new DecimalFormat("0.00").format(getLectureAverage()) + "점");
		for (int i = 0; i < idx; i++) {
			System.out.print("학생" + (i + 1) + "\t");
			students[i].printStudent();
		}
	}
	
}

// 메인클래스
public class Ex02_Student {

	public static void main(String[] args) {
		
		final int CAPACITY = 3;
		Lecture lecture = new Lecture("풀스택개발", CAPACITY);
		
		String[] name = {"철수", "영희", "미희"};
		String[] school = {"서강", "연세", "홍익"};
		
		// 학생 생성 및 추가
		for (int i = 0; i < CAPACITY; i++) {
			lecture.addStudent( new Student(name[i], school[i]) );
		}
		
		// 학생 시험 응시
		lecture.doExam();
		
		// 강의 정보 출력
		lecture.printLecture();

	}

}
