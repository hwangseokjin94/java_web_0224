package Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
Test05.java
HashMap을 이용하여 회원(Member)을 저장하시오.
key : Member, value : 포인트점수
동일한 회원은 저장될 수 없다.
Member 클래스
	필드 : int no, String name, String memberShip("VIP", "GOLD", "Silver")
3명의 회원 정보를 저장하시오.
중복 회원도 입력하시오.*/

//hashMap의 key 는 중복저장이 불가하므로,
//Member객체를 key로사용하려면 Member의 중복체크가 가능하도록
//hashCode()+equals()메소드를 오버라이드를 해야한다.

class Member {

	private int no;
	private String name;
	private String memberShip;

	public Member(int no, String name, String memberShip) {
		super();
		this.no = no;
		this.name = name;
		this.memberShip = memberShip;
	}

	@Override
	public String toString() {
		return name + "(" + memberShip + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberShip == null) ? 0 : memberShip.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Member) {
			Member other = (Member) obj;
			return no == other.no;
		}
		return false;
	}

}

public class Test05 {
	public static void main(String[] args) {
		Member m1 = new Member(10000, "앨리스", "VIP");
		Member m2 = new Member(10001, "제임스", "GOLD");

		Map<Member, Integer> pointManager = new HashMap<Member, Integer>();
		pointManager.put(m1, 1000);
		pointManager.put(m2, 500);

		pointManager.put(m1, 2000);// m1회원의 포인트는 2000으로 변경
		Set<Member> set = pointManager.keySet();
		Iterator<Member> itr = set.iterator();
		while (itr.hasNext()) {
			Member m = itr.next();
			Integer point = pointManager.get(m);
			System.out.println(m + "의 포인트 :" + point);
		}

	}
}
