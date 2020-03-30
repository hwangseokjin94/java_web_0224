package com.koreait.object;

//toString ():  객체 (인스턴스)를 String으로 변환하는 메소드
//데이터클래스
class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void printPerson() {
		System.out.println("이름  : " + name);
		System.out.println("나이 : " + age + "살");
		
	}

}

public class Ex02_toString {

	public static void main(String[] args) {
		Person p = new Person("앨리스", 25);
		String message =  p.toString();
		System.out.println("객체 p의 String 변환 : "+message);//객체 p의 String 변환 : com.koreait.object.Person@15db9742
																					//getClss() .geeName()      @hashCode()
		//toString()의 기본동작 (Object 클래스의 toString()에 정의된 내용
		//getClass().getName() @       hasCode()
		//클래스의 이름        @       객체의 주소 (참조)
		
		//지금까지의 객체 정보 확인방법.		
		p.printPerson();
		
		//앞으로 다음과 같이 객체 정보를 확인하고자 한다면,
		//어떤 작업이 필요할까?
		
		System.out.println(p);//com.koreait.object.Person@15db9742		
		System.out.println(p.toString());//위에코드와 같은 코드다.
		
		//모든애들은 equals는 쓸수있는데  String은 자기가가지고있는  equlas를 쓴다 오버라이드 (문자열비교) 
		//StinrgBuffer의 equals는 비교용으로 못쓰나. 그래서StringBuffer를 toString으로 변환을하고 equals를사용한다.
		//String의 메소드를 이용을 하기위해toString 으로 변환한다.
	}
}
