package com.koreait.ex2;

public class StudentMain {

	public static void main(String[] args) {

		Student stu = new Student("제임스", "서강대");
		
		stu.doExam();  // score 3개를 0 ~ 100 사이 랜덤 생성
		stu.printStudent();  // 이름, 학교, 점수 3개, 평균, 합격/불합격
		
	}

}
