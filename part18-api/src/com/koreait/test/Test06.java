package com.koreait.test;

/*Test06.java
User 클래스		필드 : String id, password
				메소드 : Constructor, toString(), equals()
				
toString() : 아이디 : ad***, 비밀번호 : ****   (아이디가 "admin", 비밀번호가 "1234"인 회원인 경우)
equals() : 아이디가 일치하면 true, 아니면 false
*/
class User {
	String id;
	String password;

	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuffer idStar = new StringBuffer();
		for (int i = 0; i < id.length() - 2; i++) {
			idStar.append("*");
		}
		StringBuffer pwStar = new StringBuffer();
		for (int i = 0; i < password.length() - 2; i++) {
			pwStar.append("*");
		}
		String message = "아이디 " + id.substring(0, 2) + idStar + "비밀번호" + pwStar;
		return message;
	}

	@Override
	public boolean equals(Object anObject) {
		if (this == anObject) {
			return true;
		}
		if (anObject instanceof User) {
			User obj = (User) anObject;
			return id.equals(obj.id);  // String 의 equals() 사용으로 문자열 비교
		}
		return false;
	}
	}



public class Test06 {
	public static void main(String[] args) {
		User user1 = new User("admin", "1234456");
		User user2 = new User("admin", "4567");
		System.out.println(user1);
		System.out.println(user1.toString());
		System.out.println(user2);
		System.out.println(user2.toString());

		if (user1.equals(user2)) {
			System.out.println("같은사용자이다.");
		} else {
			System.out.println("다른사용자이다.");
		}

	}
}
