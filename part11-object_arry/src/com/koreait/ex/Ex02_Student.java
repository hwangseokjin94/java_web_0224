package com.koreait.ex;

import java.text.DecimalFormat;
import java.util.Arrays;

//데이터클래스
class Student {
	String name;
	String school;
	int[] score;
	double average;
	boolean isPass;

	// 생성자

	Student(String name, String school) {
		this.name = name;
		this.school = school;
	}

	// 메소드
	void doExam() {
		score = new int[3];
		for (int i = 0; i < score.length; i++) {
			score[i] = (int) (Math.random() * 101);
		}
		average = getAverage();
		isPass = getpass();
	}

	boolean getpass() {
		return average >= 50;
	}

	double getAverage() {
		int total = 0;
		for (int i = 0; i < score.length; i++) {
			total += score[i];
		}
		return (double) total / score.length;
	}

	void printStudent() {
		DecimalFormat df = new DecimalFormat("0.00");// 0.00은 소수점을 표현해줌 #.##소수점 표시해줌
		System.out.println("학생이름 :" + name + "(" + school + ")");
		System.out.println(
				"성적 : " + Arrays.toString(score) + ", 평균 :" + df.format(average) + "점 >>" + (isPass ? "합격" : "불합격"));
	}

}// st

//데이터 클래스Lecture
class Lecture {

	String lecutreName;
	Student[] students;
	int idx;

	// Constructor
	Lecture(String lecutreName, int count) {
		this.lecutreName = lecutreName;
		students = new Student[count];
	}

	// 메소드
	void addStudent(Student stu) {

		students[idx++] = stu; // idx:인덱스(추가된 학생수)
	}

	double getLectureAverage() {
		double total = 0;
		for (int i = 0; i < idx; i++) {
			total += students[i].getAverage();

		}
		return total / idx;
	}

	void doExam() {
		for (int i = 0; i < idx; i++) {
			students[i].doExam();
		}
	}

	void printLecture() {
		System.out.println("강의명 :" + lecutreName);
		System.out.println("강의 평균 : " +new DecimalFormat("0.00").format(getLectureAverage()) + "점");
		for (int i = 0; i < idx; i++) {
			System.out.println((i + 1) + "번쨰 학생 정보 ------");
			students[i].printStudent();
		}

	}

}// lecture

public class Ex02_Student {

	public static void main(String[] args) {
		final int CAPACITY = 3;
		Lecture lecture = new Lecture("풀스택개발", CAPACITY);

		String[] name = { "철수", "영희", "미화" };
		String[] school = { "서강", "연세", "홍익" };
		
		// 학생생성및 추가
		for (int i = 0; i < CAPACITY; i++) {

			lecture.addStudent(new Student(name[i], school[i]));
		}

		lecture.doExam();
		lecture.printLecture();

	}// main

}
