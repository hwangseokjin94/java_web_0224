package com.koreait.ex;

import java.util.Scanner;

//데이터 클래스 Day
class Day {
	String schedule;// 하루에 스케줄은 하나

	Day() {

	}

	Day(String schedule) {
		this.schedule = schedule;
	}

	// 스케줄확인
	String getSchedule() {
		return schedule;
	}

	// 스케줄 저장 및 변경
	void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	void printSchedule() {
		if (schedule == null || schedule.isEmpty()) {
			System.out.println("없음");
		} else {
			System.out.println(schedule);
		}
	}

}// Class day
//데이터클래스 WeekScheduler

class WeekScheduler {
	// 필드
	int nthWeek; // 1주차~n주차
	Day[] days;
	Scanner sc;;// =new Scanner(System.in);
	final static String[] WEEKNAME = { "일", "월", "화", "수", "목", "금", "토" };

	// 생성자
	WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;
		days = new Day[7];
		for (int i = 0; i < days.length; i++) {
			days[i] = new Day();// 날짜를 다만들어놓고
		}
		sc = new Scanner(System.in);
	}

	// 1. 스케줄만들기 (스케줄이 없을떄 새로만들기)
	void makeSchedule() {
		System.out.println("스케줄을 등록할 요일(일~토) 입력 >>>");
		String weekday = sc.next();
		for (int i = 0; i < days.length; i++) {
			if (weekday.equals(WEEKNAME[i])) {
				if (days[i].getSchedule() == null || days[i].getSchedule().isEmpty()) {
					System.out.print("스케줄 입력 >>");
					String schedule = sc.next();
					days[i].setSchedule(schedule);
					System.out.println(WEEKNAME[i] + "요일에 새스케줄이 저장되었습니다.");
				} else {
					System.out.println(WEEKNAME[i] + "요일은 이미 스케줄이있습니다.");
				}
			}

		} // for
	}

	// 2.스케줄 삭제하기
	void deleteSchedule() {

		System.out.println("스케줄을 삭제할 요일(일~토) 입력 >>>");
		String weekday = sc.next();
		for (int i = 0; i < days.length; i++) {
			if (weekday.equals(WEEKNAME[i])) {
				if (days[i].getSchedule() == null || days[i].getSchedule().isEmpty()) {
					System.out.println(WEEKNAME[i] + "요일은 스케줄이 없습니다.");

				} else {
					System.out.println("삭제할 스케줄을 확인합니다.");
					days[i].printSchedule();
					System.out.print("삭제할까요(Y/N)?>>>>>>");
					String input = sc.next();
					if (input.charAt(0) == 'Y' || input.charAt(0) == 'y' || input.charAt(0) == '예') {

						days[i].setSchedule(null);
						System.out.println(WEEKNAME[i] + "요일 스케줄이 삭제되었습니다.");
					} else {
						System.out.println("취소되었습니다.");
					}
				}
			}

		} // for

	}

	// 3.스케줄 변경하기
	void changeSchedule() {

		System.out.println("스케줄을 수정할 요일(일~토) 입력 >>>");
		String weekday = sc.next();
		for (int i = 0; i < days.length; i++) {
			if (weekday.equals(WEEKNAME[i])) {
				if (days[i].getSchedule() == null || days[i].getSchedule().isEmpty()) {
					System.out.println(WEEKNAME[i] + "요일은 스케줄이 없습니다.");
					System.out.print("새 스케쥴을 등록하겠습니까??(Y/N)");
					String input = sc.next();
					if (input.charAt(0) == 'Y' || input.charAt(0) == 'y' || input.charAt(0) == '예') {
						System.out.println("새 스케줄 입력 >>>>>>>");
						String schedule = sc.next();
						days[i].setSchedule(schedule);
						System.out.println(WEEKNAME[i] + "요일에 새스케줄이 저장되었습니다.");
					} else {
						System.out.println("스케줄 수정이 취소되었습니다.");
					}
				} else {
					System.out.println("수정할 스케줄을 확인합니다.");
					days[i].printSchedule();
					System.out.print("수정할까요(Y/N)?>>>>>>");
					String input = sc.next();
					if (input.charAt(0) == 'Y' || input.charAt(0) == 'y' || input.charAt(0) == '예') {
						System.out.print("수정할스케줄을 입력>>>");
						String schedule = sc.next();
						days[i].setSchedule(schedule);
						System.out.println(WEEKNAME[i] + "요일 스케줄이 수정되었습니다.");
					} else {
						System.out.println("취소되었습니다.");
					}
				}
			}

		} // for
	}

	// 4. 일주일전체스케줄ㅊ 출력하기
	void printWeekSchedule() {
		System.out.println(nthWeek + "주차 스케줄 안내  - ------");
		for (int i = 0; i < days.length; i++) {
			System.out.print(WEEKNAME[i] + "요일 :");
			days[i].printSchedule();
		}
	}

	// 5. 종료
	void exit() {
		System.out.println("프로그램을 종료합니다.");
		sc.close();

	}

	// 6. 메뉴출력
	static void menu() {
		System.out.println();
		System.out.println("1. 스케줄 만들기");
		System.out.println("2. 스케줄 삭제하기");
		System.out.println("3. 스케줄 수정하기");
		System.out.println("4. 스케줄 전체출력하기");
		System.out.println("0. 프로그램 종료");
		System.out.println();

	}

	// 7. 실행
	void run() {
		while (true) {
			menu();
			System.out.println("메뉴선택 >>>");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				makeSchedule();
				break;
			case 2:
				deleteSchedule();
				break;
			case 3:
				changeSchedule();
				break;
			case 4:
				printWeekSchedule();
				break;
			case 0:
				exit();
				return;// return; run()메소드종료
			default:
				System.out.println("오류 . 없는 메뉴입니다. 다시 입력하세요");

			}
		}
	}

}// weeksc

public class Ex04_WeekScheduler {

	public static void main(String[] args) {
		WeekScheduler firstWeek = new WeekScheduler(1);
		firstWeek.run();

	}

}
