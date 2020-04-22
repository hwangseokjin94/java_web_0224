package com.koreait.ex;

//무엇이든 담을수있는 GenericOmniBox 
class GenericOmniBox<T> { // T :어떤 타입 ( 자료형 ) ->생성자가 GenericOmniBox<전달할타입>() 형태가 된다.
	// 필드
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
}


class BallPen {
	
}
class Eraser{
	
}



public class Ex02_GenericOmniBox {

	public static void main(String[] args) {
//		GenericOmniBox 의생성 어떤타입을 저장할것인지 명시해야만 한다.

		 
		GenericOmniBox<String> box = new GenericOmniBox<>();
//		GenericOmniBox<String>Box = new GenericOmniBox<String>(); //뒤에 <String>생략할수도있다. 위와 같은코드이다.
		// 생성자가 호출되는 순간 GenericOmniBox 클래스는 T대신 String 을 사용하게된다.
		
		/*
		 * class GenericOmniBox<T> { 
		 * private String obj ;
		 *  public String getObj() { return obj; }
		 * 
		 * public void setObj(String obj) {
		 *  this.obj=obj; 
		 *  }
		 *  } T가 String으로 바꾸어버린다.
		 **/ 

		
		//정상처리
		box.setObj("자바");
		String obj =box.getObj();
		System.out.println(obj);
		
		
		//비정상처리
//		box.setObj(10);
//		int a =box.getObj();
		
		GenericOmniBox<BallPen> ballPenBox = new GenericOmniBox<>();
		ballPenBox.setObj(new BallPen());
		BallPen pen = ballPenBox.getObj();
		System.out.println(pen);
		
		GenericOmniBox<Eraser> eraserBox = new GenericOmniBox<>();
//		eraserBox.setObj(new BallPen());    //legacyOnmiBox 에서는 가능한작업
//		BallPen pen =eraserBox.getObj()   //legacyOnmiBox 에서는 가능한작업
		
		
	}

}
