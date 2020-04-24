package com.koreaitex;
//데이터 클래스 Parent
class Parent {
	private String wallet; //클래스 Parent 내부에서만 접근이가능하다.
	String album ; //default : 같은패키지
	protected String cosmetic ; // protected접근권한 같은패키지 com.koreait.ex내부_+다른패키지에 있는 자식클래스
	public String name ;
}

//
public class Ex01_access_modifier {

	public static void main(String[] args) {
	Parent parent = new Parent();
//	parent.wallet;클래스 Parent 외부에서는 접근이 불가능하다..
	parent.album = "결혼앨범 " ; //같은 패키지내에서는 접근이 가능하다..,
	parent.cosmetic = "스킨";//같은 패키지 +다른 패키지(자식)은 접근이가능
	parent.name  =   "스미스";//접근이 어디서든 가능하다
	}

}
