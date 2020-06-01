package dto;

import java.sql.Date;

// BLUE 테이블의 데이터를 하나의 객체로 만들어주는 클래스

//DTO : Data Transfer Object
//VO : value Object

//테이블의 모든 칼럼을 필드로 생성하고 ,getter /setter를 만든다.



public class BlueDto {

	//필드
	int no,age;
	String id ,pw, name, email;
	Date reg_date;
	
	//생성자
	
	
	//메소드

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
}
