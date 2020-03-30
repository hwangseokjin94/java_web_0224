package com.koreait.ex;

class Watch {
	int hour;// 0~23
	int minute;// 0~59
	int second;// 0~59

	public Watch(int hour, int minute, int second) {

		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	void addHour(int hour) {

		if (hour <= 0) {
			return;
		}

		this.hour += hour;
		this.hour = this.hour % 24; // this.hour %=24

	}

	void addMinute(int minute) {
		if (minute <= 0) {
			return;
		}

		this.minute += minute;
		addHour(this.minute / 60);
		this.minute = this.minute % 60;

	}

	void addSecond(int second) {
		this.second += second;
		addHour(this.second/3600);
		addMinute(this.second %3600/ 60);
		this.second = this.second % 60;

	}

	void see() {
		System.out.println(hour + " 시 " + minute + " 분 " + second + "초");
	}

}

public class Ex04_Watch {

	public static void main(String[] args) {
		Watch watch = new Watch(9, 25, 0);
		watch.addHour(25);// 25시간후 1시간후
		watch.addMinute(61); // 61분후 (1시간 1분후)
		watch.addSecond(3661);// (1시간1 분 1초후)
		watch.see();
	}

}
