
package com.koreait.ex;

class Person {
	// field
	private int age;
	//method

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception{ //2.throw문으로 예외가 던지는 경우 throws는 필수로 작성한다.
		//나이는 0~120사이로 가정
		if(age<0||age >120) { // //자바가 인지하지 못하는 예외는 개발자가 직저예외를 발생시킬수있다.
//			return;
			throw new Exception();//1.개발자가 예외 객체를 만들어서 직접 예외를 던지는 경우
		}
		this.age = age;
	}
	
}

public class Ex10_throw {

	public static void main(String[] args) {
		Person p = new Person();
		try {
		p.setAge(-1);
		System.out.println("나이  : " + p.getAge());
		}catch (Exception e) {
			System.out.println("나이는 0~120 사이만 가능하다.");
		}
	}

}
