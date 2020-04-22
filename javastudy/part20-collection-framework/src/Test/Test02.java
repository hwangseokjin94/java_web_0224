package Test;

import java.util.ArrayList;
import java.util.List;

/*

Test02.java
Container 제네릭 클래스를 정의하시오.
한 가지 타입의 객체를 여러 개 저장할 수 있는 ArrayList 를 이용하시오.
물건만담을수있는 ArrayList 관점.
*/
//제네릭타입(미리타입을지정하면 무엇이든저장할수있는타입
class Container<T> { // T:제네릭타입(다른이름도 상관이없다.
                                             //컨데이너에 물건만 보관하는게아님 private String location;
	// private T[] list;
	private List<T> list;                    

	public Container() {
		list = new ArrayList<>();
	}

	// method
	public void add(T item) {// T타입의 데이터를 받아오겠다. 리스트에 아이템넣기
		list.add(item);

	}

	public T get(int index) {// 뺴오기
		return list.get(index);
	}

	public int size() {// 몇개의 아이템이 들어가있느냐
		return list.size();
	}

	public T remove(int index) { // 인덱스를 받아서 삭제 삭제하는 데이터를 보이기때문에 T타입
		return list.remove(index);// 지우는게 끝이아니라 데이터를보여주기때문에 리턴을한다.
	}

}
class Gun{
	private String model ; 
	private int bullet;
	public Gun(String model, int bullet) {
	
		this.model = model;
		this.bullet = bullet;
	}
	@Override
	public String toString() {
		return model+" : ("+bullet+")발 ";
	}
}

public class Test02 {
	public static void main(String[] args) {
		Container<Gun> gunLocker = new Container<>(); //총기보관함에 총을 넣겠따.
		gunLocker.add(new Gun("베레타",6));
		gunLocker.add(new Gun("콜트",6));
		gunLocker.add(new Gun("k2",15));
		
		gunLocker.remove(1);
		
		for(int i = 0 ; i <gunLocker.size(); i++) {
			System.out.println(gunLocker.get(i)); //베레타(6발) k2(15)발
		}
		
	}
}
