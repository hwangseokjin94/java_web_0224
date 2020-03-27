package com.koreait.ex2;
//부모
class Parent{
	String parentName;
	Parent(){
		parentName ="알수없음 ";
	}
	Parent(String parentName){
		this.parentName =parentName; 
	}
	
	void printParent(){
		System.out.println("부모  : "+parentName);
		
	}
	
	
}//


class  Child  extends Parent{
	String childName ; 

	Child(String childName){
		super();//  Parent(){parentName ="알수없음 ";}
		this.childName = childName ;
	}
	Child(String childName ,String parentName){
		super(parentName); //	Parent(String parentName){this.parentName =parentName; }

		this.childName = childName;
		
		
	}
	void printChild() {
		
		printParent();
//		super.printParent();  위와같음
		System.out.println("자식   :  "+childName);
	}	
	
}


public class Ex01_Parent {
	public static void main(String[] args) {
		Child  child1 = new Child("홍길동");
		Child  child2 = new Child("제임스","스미스" );
				
		child1.printChild();
		child2.printChild();
		
		
		
		
		
		
		
		
		
		
		
	}
}
