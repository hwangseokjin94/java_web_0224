package com.koreait.run;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.koreait.dao.Dao;

public class JobManager {

	// Field
	// DB 접근은 DAO 가 한다.
	private static Dao dao = new Dao();

	// Method

	// 1. 삽입 메소드
	public static void insert() {
		String job_id = JOptionPane.showInputDialog("JOB_ID 입력하세요.");
		String job_title = JOptionPane.showInputDialog("JOB_TITLE 입력하세요.");
		int min_salary = Integer.parseInt(JOptionPane.showInputDialog("MIN_SALARY 입력하세요."));
		int max_salary = Integer.parseInt(JOptionPane.showInputDialog("MAX_SALARY 입력하세요."));

		int result = dao.insert(job_id, job_title, min_salary, max_salary);
		JOptionPane.showMessageDialog(null, result + "개 직업이 추가되었다.");
	}

	// 2. 삭제 메소드
	public static void delete() {
		String job_id = JOptionPane.showInputDialog("삭제할 JOB_ID 입력하세요.");
		int result = dao.delete(job_id);
		JOptionPane.showMessageDialog(null, result + "개 직업이 삭제되었다.");
	}

	// 3. 갱신 메소드
	public static void update() {
		String job_id = JOptionPane.showInputDialog("JOB_ID 입력하세요.");
		int min_salary = Integer.parseInt(JOptionPane.showInputDialog("MIN_SALARY 입력하세요."));
		int max_salary = Integer.parseInt(JOptionPane.showInputDialog("MAX_SALARY 입력하세요."));
		int result = dao.update(job_id, min_salary, max_salary);
		JOptionPane.showMessageDialog(null, result + "개 직업이 갱신되었다.");
	}

	// 4. 검색 메소드
	public static void select() {
		String job_id = JOptionPane.showInputDialog("검색할 JOB_ID 입력하세요.");
		ResultSet rs = dao.select(job_id);
		System.out.println("JOB_ID\tJOB_TITLE\tMIN_SALARY\tMAX_SALARY");
		System.out.println("==========================================");
		try {
			while (rs.next()) {
				String job_id2 = rs.getString(1);
				String job_title = rs.getString(2);
				int min_salary = rs.getInt(3);
				int max_salary = rs.getInt(4);
				System.out.println(job_id2+"\t"+job_title+"\t"+min_salary+"\t"+max_salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		while (true) {
			int choice = Integer.parseInt(JOptionPane.showInputDialog("1. 삽입\n2. 삭제\n3. 갱신\n4. 검색\n5. 종료\n선택하세요"));
			switch (choice) {
			case 1:
				insert();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				select();
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "프로그램을 종료한다.");
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "잘못된 선택이다. 다시 선택하시오.");
			}
		}

	}

}
