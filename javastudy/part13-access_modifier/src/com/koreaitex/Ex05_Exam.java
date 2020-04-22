package com.koreaitex;

class Exam {
	private String examName;
	private int kor, eng, mat;
	private double average;
	private char grade;

	public Exam(String examName, int kor, int eng, int mat) {
	super();//java.lang.object 클래스를 의미(생략하는 메뉴를 쓰기도하지만 대부분 그냥 둠.)
	this.examName = examName;
	this.kor = kor ;
	this.eng = eng;
	this.mat = mat;
	setAverage(kor, eng ,mat);
	setGrade();
	}
	
	// 메소드
	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
		
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	private void setAverage(int kor, int eng , int mat) {
		this.average = (kor+eng+mat)/3.0;;
	}
	
	private  void setGrade() {
		switch (((int)average)%10) {
		case 0:case 9:
			this.grade='A';
			break;
		case 8:
			this.grade='B';
			break;
		case 7:
			this.grade='C';
			break;
		case 6:
			this.grade='D';
			break;
		default:
			this.grade='F';
			break;
		}

	}
	
	//get

	public String getExamName() {
		return examName;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMat() {
		return mat;
	}

	public double getAverage() {
		return average;
	}

	public char getGrade() {
		return grade;
	}




}

public class Ex05_Exam {
	public static void main(String[] args) {
	Exam exam = new Exam("중간고사",60,61,62);
	
	System.out.println("평균 : "+exam.getAverage() +"점"); // 평균 61.0
	System.out.println("학점 : "+exam.getGrade() +"학점"); //학점 D학점
   }
}
