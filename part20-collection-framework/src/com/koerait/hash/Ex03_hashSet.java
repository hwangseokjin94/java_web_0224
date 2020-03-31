package com.koerait.hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Member {
	private int memberIdx; // 회원들의 순번 (가입에따라 순차적인 순번을 받는다.)
	private String memberPw;
	private String memberName;

	public Member(int memberIdx, String memberPw, String memberName) {
		super();
		this.memberIdx = memberIdx;
		this.memberPw = memberPw;
		this.memberName = memberName;
	}


	//method
	
	
	//Member 객체를 hash 기반의 hashSet hashMap에저장하려면
	//1.hashCode()메소드를 오버라이드하고,(자동으로 처리)
	//2. equals()메소드를 오버라이드를 해야한다. (개발자가 직접)
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + memberIdx;
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberPw == null) ? 0 : memberPw.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj instanceof Member) {
		Member other = (Member) obj;
		return memberIdx == other.memberIdx;
		}return false;
		
	}
	@Override
	public String toString() {
		return memberName;
	}
	
	
}

public class Ex03_hashSet {
	public static void main(String[] args) {
		
		Set<Member> pool = new HashSet<Member>();
		pool.add(new Member(1, "123", "앨리스"));
		pool.add(new Member(2, "123", "제임스"));
		pool.add(new Member(3, "123", "데이빗"));

		pool.add(new Member(1, "123", "앨리스"));//중복 저장 시도
		
		Iterator<Member> itr = pool.iterator();
		while(itr.hasNext()) {
			Member member = itr.next();
			System.out.println(member);  //itr.next() ->toString()호출
			 

		}
		
		
		
	}
}
