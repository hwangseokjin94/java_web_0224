package Test;

import java.util.HashMap;
import java.util.Map;

/*
Test05.java
HashMap을 이용하여 회원(Member)을 저장하시오.
key : Member, value : 포인트점수
동일한 회원은 저장될 수 없다.
Member 클래스
	필드 : int no, String name, String memberShip("VIP", "GOLD", "Silver")
3명의 회원 정보를 저장하시오.
중복 회원도 입력하시오.*/
class Member{
	int no;
	String name;
	String[] memberShip = {"VIP", "GOLD", "Silver"};
	public Member(int no, String name, String[] memberShip) {
		super();
		this.no = no;
		this.name = name;
		this.memberShip = memberShip;
	}
	
	
}
public class Test05 {
public static void main(String[] args) {
	Map<Integer,Object > person = new HashMap<>();
	person.put(1,new Member(1,"오바", "VIP") );
	
}
}
