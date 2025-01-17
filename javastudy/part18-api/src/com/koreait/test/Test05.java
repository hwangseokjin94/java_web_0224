package com.koreait.test;

class Score {
	int kor, eng, mat;

	public Score(int kor, int eng, int mat) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	@Override
	public String toString() {
		String mesaage = " 국어 " + kor + " 영어 " + eng + " 수학 " + mat;
		return mesaage;

	}

	@Override
	public boolean equals(Object anObject) {
		if (this == anObject) {
			return true;
		}

		if (anObject instanceof Score) {
			Score obj = (Score) anObject;
			if (kor == obj.kor && eng == obj.eng && mat == obj.mat) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

}

public class Test05 {
	public static void main(String[] args) {
		/*
		 * Test05.java Score 클래스 필드 : int kor, eng, mat 메소드 : toString(), equals()
		 * 
		 * Score 인스턴스를 2개 생성하고, 동등 비교(세 과목이 모두 같으면 동등) 결과 출력 각 인스턴스 정보는 toString 메소드를 통해
		 * 출력
		 */

		Score score1 = new Score(70, 80, 90);
		Score score2 = new Score(70, 80, 90);
		System.out.println(score1);
		System.out.println(score1.toString());
		

		if(score1.equals(score2)) {
			System.out.println("점수가같다.");
		}else {
			System.out.println("점수가 다르다");
		}

	}
}
