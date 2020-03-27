package com.koreait.ex;

import java.util.Scanner;

// 데이터클래스 Day
class Day {
	
	// Field
	String schedule;
	
	// Constructor
	Day() { }
	Day(String schedule) {
		this.schedule = schedule;
	}
	
	// Method
	// 스케쥴 확인
	String getSchedule() {
		return schedule;
	}
	// 스케쥴 저장 및 변경
	void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	void printSchedule() {
		if (schedule == null || schedule.isEmpty()) {
			System.out.println("없음.");
		} else {
			System.out.println(schedule);
		}
	}
	
}


// 데이터클래스 WeekSchduler
class WeekScheduler {
	
	// Field
	int nthWeek;  // 1주차 ~ n주차
	Day[] days;
	Scanner sc;
	final static String[] WEEKNAME = {"일", "월", "화", "수", "목", "금", "토"};
	
	// Constructor
	WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;
		days = new Day[7];
		for (int i = 0; i < days.length; i++) {
			days[i] = new Day();
		}
		sc = new Scanner(System.in);
	}
	
	// Method
	
	// 1. 스케쥴 만들기 (스케쥴이 없을 때 새로 만들기)
	void makeSchedule() {
		System.out.print("스케쥴을 등록할 요일(일~토) 입력 >> ");
		String weekday = sc.next();
		sc.nextLine();  // 입력 버퍼에 남아 있는 '\n' 제거
		for (int i = 0; i < days.length; i++) {
			if (weekday.equals(WEEKNAME[i])) {
				if (days[i].getSchedule() == null || days[i].getSchedule().isEmpty()) {
					System.out.print("스케쥴 입력 >> ");
					String schedule = sc.nextLine();
					days[i].setSchedule(schedule);
					System.out.println(WEEKNAME[i] + "요일에 새 스케쥴이 저장되었습니다.");
				} else {
					System.out.println(WEEKNAME[i] + "요일은 이미 스케쥴이 있습니다.");
				}
			}
		}
	}
	
	// 2. 스케쥴 삭제하기
	void deleteSchedule() {
		System.out.print("스케쥴을 삭제할 요일(일~토) 입력 >> ");
		String weekday = sc.next();
		sc.nextLine();
		for (int i = 0; i < days.length; i++) {
			if (weekday.equals(WEEKNAME[i])) {
				if (days[i].getSchedule() == null || days[i].getSchedule().isEmpty()) {
					System.out.println(WEEKNAME[i] + "요일은 스케쥴이 없습니다.");					
				} else {
					System.out.println("삭제할 스케쥴을 확인합니다.");
					days[i].printSchedule();
					System.out.print("삭제할까요(Y/N)? >> ");
					String input = sc.next();
					sc.nextLine();
					if (input.charAt(0) == 'Y' || input.charAt(0) == 'y' || input.charAt(0) == '예') {
						days[i].setSchedule(null);
						System.out.println(WEEKNAME[i] + "요일의 스케쥴이 삭제되었습니다.");
					} else {
						System.out.println("취소되었습니다.");
					}
				}
			}
		}
	}
	
	// 3. 스케쥴 변경하기
	void changeSchedule() {
		System.out.print("스케쥴을 수정할 요일(일~토) 입력 >> ");
		String weekday = sc.next();
		sc.nextLine();
		for (int i = 0; i < days.length; i++) {
			if (weekday.equals(WEEKNAME[i])) {
				if (days[i].getSchedule() == null || days[i].getSchedule().isEmpty()) {
					System.out.println(WEEKNAME[i] + "요일은 스케쥴이 없습니다.");
					System.out.print("새 스케쥴을 등록하겠습니까(Y/N)? >> ");
					String input = sc.next();
					sc.nextLine();
					if (input.charAt(0) == 'Y' || input.charAt(0) == 'y' || input.charAt(0) == '예') {
						System.out.print("새 스케쥴 입력 >> ");
						String schedule = sc.nextLine();
						days[i].setSchedule(schedule);
						System.out.println(WEEKNAME[i] + "요일에 새 스케쥴이 저장되었습니다.");
					} else {
						System.out.println("스케쥴 수정이 취소되었습니다.");
					}
				} else {
					System.out.println("수정할 스케쥴을 확인합니다.");
					days[i].printSchedule();
					System.out.print("수정할까요(Y/N)? >> ");
					String input = sc.next();
					sc.nextLine();
					if (input.charAt(0) == 'Y' || input.charAt(0) == 'y' || input.charAt(0) == '예') {
						System.out.print("수정할 스케쥴 입력 >> ");
						String schedule = sc.nextLine();
						days[i].setSchedule(schedule);
						System.out.println(WEEKNAME[i] + "요일의 스케쥴이 수정되었습니다.");
					} else {
						System.out.println("취소되었습니다.");
					}
				}
			}
		}
	}
	
	// 4. 일주일 전체 스케쥴 출력하기

	void printWeekSchedule() {
		System.out.println(nthWeek + "주차 스케쥴 안내 -----");
		for (int i = 0; i < days.length; i++) {
			System.out.print(WEEKNAME[i] + "요일 : ");
			days[i].printSchedule();
		}
	}
	
	// 5. 종료
	void exit() {
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}
	
	// 6. 메뉴 출력
	static void menu() {
		System.out.println();
		System.out.println("1. 스케쥴 만들기");
		System.out.println("2. 스케쥴 삭제하기");
		System.out.println("3. 스케쥴 수정하기");
		System.out.println("4. 스케쥴 전체 출력하기");
		System.out.println("0. 프로그램 종료");
		System.out.println();
	}
	
	// 7. 실행
	void run() {
		while (true) {
			menu();
			System.out.print("메뉴 선택 >> ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1 : makeSchedule(); break;
			case 2 : deleteSchedule(); break;
			case 3 : changeSchedule(); break;
			case 4 : printWeekSchedule(); break;
			case 0 : exit(); return;  // run() 메소드의 종료
			default : System.out.println("오류. 없는 메뉴입니다. 다시 입력하세요.");
			}
		}
	}
	
}

// 메인클래스
public class Ex04_WeekScheduler {

	public static void main(String[] args) {
		
		WeekScheduler firstWeek = new WeekScheduler(1);
		firstWeek.run();

	}

}
