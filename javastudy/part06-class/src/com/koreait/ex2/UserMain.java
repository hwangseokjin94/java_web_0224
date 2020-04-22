package com.koreait.ex2;

public class UserMain {

	public static void main(String[] args) {
		
		User user1 = new User();
		user1.setUser("admin", "123456", "관리자");
		user1.printUser();
		
		User user2 = new User();
		user2.setUser("niceguy", "654321", "김핸섬");
		user2.printUser();

	}

}
