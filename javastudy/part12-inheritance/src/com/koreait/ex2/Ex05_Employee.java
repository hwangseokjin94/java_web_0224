package com.koreait.ex2;

//부모 슈퍼
class Employee {

	String name;
	String department;

	Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	int getPay() {
		return 0;// 월급이 없다(존재하면 안되는 코드 ->추상클래스를 이용해서 해결 예정)
	}

}

class SalaryMan extends Employee {

	int salary;

	SalaryMan(int salary, String name, String department) {
		super(name, department);
		this.salary = salary;
	}

	@Override
	int getPay() {

		return salary; //
	}
}

class SalesMan extends SalaryMan {

	double salesIncentive;
	int salesVolume;

	SalesMan(double salesIncentive, int salary, String name, String department) {
		super(salary, name, department);
		this.salesIncentive = salesIncentive;
	}

	void setSalesVolume(int salesVolume) {
		if (salesVolume < 0) {
			return;
		}
		this.salesVolume = salesVolume;
	}

	int getSalesPay() {//판매수당 = 판매량*판매 인센티브
		return (int) (salesVolume * salesIncentive);
	}

	@Override
	int getPay() { //기본급 +판매수당
		return super.getPay() + getSalesPay();
		

	}
}

class PartTimeWorker extends Employee {
	int payPerHour; // 시급
	int workTime; // 일한시간

	PartTimeWorker(int payPerHour, String name, String department) {
		super(name, department);
		this.payPerHour = payPerHour;

	}

	void setWorkTime(int workTime) {

		if (workTime < 0) {
			return;

		} else if (workTime > 200) {
			this.workTime = 200;
		} else {

			this.workTime = workTime;
		}
	}//

	@Override
	int getPay() {

		return payPerHour * workTime;

	}

}

public class Ex05_Employee {
	public static void main(String[] args) {
		// 3종류의 직원 생성
		SalaryMan salaryman = new SalaryMan(300, "톰", "홍보부");
		SalesMan salesman = new SalesMan(0.1, 100, "존", "영업부");
		salesman.setSalesVolume(1000);
		PartTimeWorker albaMan = new PartTimeWorker(1, "폴", "판매부");
		albaMan.setWorkTime(150);

		System.out.println("salaryMan 월급 :" + salaryman.getPay());
		System.out.println("salaesMan 월급 :" + salesman.getPay());
		System.out.println("albaMan 월급 :" + albaMan.getPay());

	}
}
