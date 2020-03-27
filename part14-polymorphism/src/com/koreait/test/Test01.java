package com.koreait.test;

class Employee {
	String name;
	String department;

	public Employee(String name, String department) {
		super();
		this.name = name;
		this.department = department;
	}

	public int getPay() {
		return 0;
	}

	public void empInfo() {
		System.out.print("이름 : " + name + "\n" + " 부서 :" + department + "\n");
	}
}

class SalaryWorker extends Employee {
	private int salary;

	public SalaryWorker(String name, String department, int salary) {
		super(name, department);
		this.salary = salary;
	}

	@Override
	public int getPay() {
		return salary;
	}

	@Override
	public void empInfo() {
		super.empInfo();
		System.out.println("기본급 : " + salary);
	}

}

class SalesWorker extends SalaryWorker {
	private int salesVolume;
	private double salesIncentive;// 500이하 1% 500~1000 5% 1000이상10%

	public SalesWorker(String name, String department, int salary) {
		super(name, department, salary);

	}

	public int getSalesPay() {
		return (int) (salesVolume * salesIncentive);
	}

	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
		if (salesVolume < 500) {
			setSalesIncentive(0.01);// salesIncentive = 0.01;
		} else if (salesVolume < 1000) {
			setSalesIncentive(0.05); // salesIncentive = 0.05;
		} else {
			setSalesIncentive(0.1); // salesIncentive = 0.1;
		}
	}

	public void setSalesIncentive(double salesIncentive) {
		this.salesIncentive = salesIncentive;
	}

	@Override
	public int getPay() {
		return super.getPay() + getSalesPay();
	}

	@Override
	public void empInfo() {

		super.empInfo();
		System.out.println("판매수당 : " + getSalesPay());
		System.out.println("월급 : " + getPay());
	}
}

class PartTimeWorker extends Employee {
	private int workTime;
	private int payPerHour;

	public PartTimeWorker(String name, String department, int payPerHour) {
		super(name, department);
		this.payPerHour = payPerHour;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	@Override
	public int getPay() {
		return workTime * payPerHour;
	}

	@Override
	public void empInfo() {
		super.empInfo();
		System.out.println(" 월급 : " + getPay());

	}

}

class EmployeeManager {
	Employee[] empList;
	int idx;

	public EmployeeManager(int count) {
		empList = new Employee[count];

	}

	public void addEmployee(Employee emp) {
		empList[idx++] = emp;
	}
	public void empInfo() {
		for (Employee staff : empList) {

			if (staff instanceof SalesWorker) {
				((SalesWorker) staff).setSalesVolume(1000);
			} else if (staff instanceof PartTimeWorker) {
				((PartTimeWorker) staff).setWorkTime(200);
			}
			staff.empInfo();
			System.out.println("=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ");
		}
	}

}

public class Test01 {
	public static void main(String[] args) {
	/*
		Employee[] empList = new Employee[3];
		
		empList[0] = new SalaryWorker("제임스", "마케팅", 200);
		empList[1] = new SalesWorker("엘리스", "마케팅부서", 100);
		empList[2] = new PartTimeWorker("스미스", "파트타임", 1);
		
		for (Employee staff : empList) {

			if (staff instanceof SalesWorker) {
				((SalesWorker) staff).setSalesVolume(1000);
			} else if (staff instanceof PartTimeWorker) {
				((PartTimeWorker) staff).setWorkTime(200);
			}
			staff.empInfo();
			System.out.println("=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ=ㅡ");
		}
*/
		
		
		EmployeeManager  manager = new EmployeeManager(3);//직원관리 3명관리
		manager.addEmployee(new SalaryWorker("제임스", "마케팅", 200));
		manager.addEmployee(new SalesWorker("엘리스", "마케팅부서", 100));
		manager.addEmployee(new PartTimeWorker("스미스", "파트타임", 1));
		
		manager.empInfo();
	

	}
}
